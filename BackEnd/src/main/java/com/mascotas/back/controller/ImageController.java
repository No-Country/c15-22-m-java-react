package com.mascotas.back.controller;

import com.mascotas.back.dto.ImageDto;
import com.mascotas.back.dto.ImageResponseDto;
import com.mascotas.back.exception.ResourceNotFoundException;
import com.mascotas.back.model.Image;
import com.mascotas.back.service.ImageService;

import java.net.URI;
import java.util.List;

import com.mascotas.back.service.PetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@CrossOrigin(origins= {"http://localhost:5173", "https://c15-22-m-java-react.vercel.app/,https://c15-22-m-java-react.vercel.app/"})
public class ImageController {

    private final ImageService imageService;
    private final PetService petService;

    @DeleteMapping("/image/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteImage(@PathVariable Long id) {
        if (!imageService.existsById(id)) throw new ResourceNotFoundException("image", "id", id);
        imageService.deleteImage(id);
    }

    @GetMapping("/images/{pet_id}")
    public ResponseEntity<List<ImageResponseDto>> listImages(@PathVariable Long pet_id) {
        List<Image> images = imageService.listImage(pet_id);
        if (!petService.existsById(pet_id)) throw new ResourceNotFoundException("pet", "pet_id", pet_id);
        if (images == null || images.isEmpty()) throw new ResourceNotFoundException("images");
        List<ImageResponseDto> imageDtoList = images.stream().map(  // Convertir una lista de tipo Image a lista de tipo ImageResponseDto con patrón Builder
                                                                    image -> ImageResponseDto
                                                                            .builder()
                                                                            .image_id(image.getId())
                                                                            .imageBase64(image.getImage())
                                                                            .build()
                                                                  ).toList();
        return ResponseEntity.ok(imageDtoList);
    }

    @GetMapping("/image/{image_id}")
    public ResponseEntity<ImageDto> getImage(@PathVariable Long image_id) {
        ImageDto imageDto = imageService.findImageById(image_id);
        if (imageDto == null) throw new ResourceNotFoundException("image", "image_id", image_id);
        return ResponseEntity.ok(imageDto);
    }

    @PostMapping("/image/{pet_id}")
    public ResponseEntity<ImageResponseDto> createImage(@RequestBody @Valid ImageDto imageDto, @PathVariable Long pet_id, UriComponentsBuilder uriComponentsBuilder){
        if (!petService.existsById(pet_id)) throw new ResourceNotFoundException("pet", "pet_id", pet_id);
        Image image = imageService.saveImage(imageDto.imageBase64, pet_id);
        URI url = uriComponentsBuilder.path("api/v1/image/{image_id}").buildAndExpand(image.getId()).toUri();
        ImageResponseDto imageResponse = ImageResponseDto
                                            .builder()
                                            .image_id(image.getId())
                                            .imageBase64(image.getImage())
                                            .build();
        return ResponseEntity.created(url).body(imageResponse);
    }

    @PutMapping("/image/{image_id}")
    public ResponseEntity<ImageDto> updateImage(@RequestBody @Valid ImageDto imageDto, @PathVariable Long image_id) {
       if (imageService.existsById(image_id)) {
            Image image = imageService.updateImage(imageDto.imageBase64, image_id);
            ImageDto imageResponseDto = ImageDto
                    .builder()
                    .imageBase64(image.getImage())
                    .build();
            return ResponseEntity.ok(imageResponseDto);
        } else {
           throw new ResourceNotFoundException("image", "image_id", image_id); // Crear excepción personalizada NOT_FOUND (id no existe)
        }
    }

}