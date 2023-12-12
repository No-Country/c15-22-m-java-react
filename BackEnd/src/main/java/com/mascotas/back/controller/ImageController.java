package com.mascotas.back.controller;

import com.mascotas.back.dto.ImageDto;
import com.mascotas.back.model.Image;
import com.mascotas.back.service.ImageService;

import java.util.List;
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

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@CrossOrigin(origins="http://localhost:5173")
public class ImageController {

    private final ImageService imageService;

    @DeleteMapping("/image/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteImage(@PathVariable Long id) {
        imageService.deleteImage(id);
    }

    @GetMapping("/image/{pet_id}")
    public ResponseEntity<List<ImageDto>> listImage(@PathVariable Long pet_id) {
        List<Image> images = imageService.listImage(pet_id);
        List<ImageDto> imageDtoList = images.stream().map( // Iterando sobre la lista de tipo Image para obtener el campo "byte[] image"
                                                        image -> new ImageDto(image.getImage())
                                                        ).toList();
        return ResponseEntity.ok(imageDtoList);
    }
    
    @PostMapping("/image/{pet_id}")
    public ResponseEntity<ImageDto> createImage(@RequestBody ImageDto imageDto ,@PathVariable Long pet_id){
        Image image = imageService.saveImage(imageDto.imageBase64, pet_id);
        ImageDto imageResponse = ImageDto.builder()
                .imageBase64(image.getImage())
                .build();
        return ResponseEntity.ok(imageResponse);
    }

    @PutMapping("/image/{id}")
    public  ResponseEntity<ImageDto> updateImage(@PathVariable Long id, @RequestBody ImageDto imageDto) {
       if (imageService.existsById(id)) {
            Image image = imageService.updateImage(imageDto.imageBase64, id);
            //Ejemplo para los create con Dto
            ImageDto imageResponseDto = ImageDto
                    .builder()
                    .imageBase64(image.getImage())
                    .build();
            return ResponseEntity.ok(imageResponseDto);
        } else {
            return null; // Crear excepción personalizada NOT_FOUND (id no existe)
        }
    }

}