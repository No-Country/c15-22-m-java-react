/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mascotas.back.controller;

import com.mascotas.back.dto.ImageDto;
import com.mascotas.back.model.Image;
import com.mascotas.back.model.Pet;
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

/**
 *
 * @author mathi
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@CrossOrigin()
public class ImageController {

    private final ImageService imageService;

    @DeleteMapping("/image/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteImage(@PathVariable Long id) {
        imageService.deleteImage(id);
    }

    @GetMapping("/image/{id}")
    public ResponseEntity<List<Image>> listImage(@PathVariable Long id) {
        List<Image> list = imageService.listImage(id);
        return ResponseEntity.ok(list);
    }
    
    @PostMapping("/image/{id}")
    public ResponseEntity<ImageDto> createImage(@RequestBody ImageDto imageDto ,@PathVariable Long id){
        
        Image image = imageService.saveImage(imageDto.imageBase64, id);
        ImageDto imageResponse = ImageDto.builder()
                .imageBase64(image.getImage())
                .build();
        return ResponseEntity.ok(imageResponse);
    }

    
    @PutMapping("/image/{id}")
    public  ResponseEntity<ImageDto> updateImage(@PathVariable Long id, @RequestBody ImageDto imageDto) {

           if (imageService.existsById(id)) {
            Image image = imageService.updateImage(id, imageDto.imageBase64);
            ImageDto imageResponseDto = new ImageDto()
                    .builder()
                    .imageBase64(image.getImage())
                    .build();
            return ResponseEntity.ok(imageResponseDto);
        } else {
            return null; // Crear excepción personalizada NOT_FOUND (id no existe)
        }            /*-----Linkear a front----*/
        }
   
    
    
    
    
    
}

/*
Ejemplo para los create con Dto
PetResponseDto petResponseDto = PetResponseDto
                .builder()
                .id(pet.getId())
                .name(pet.getName())
                .description(pet.getDescription())
                .type(pet.getType())
                .race(pet.getRace())
                .age(pet.getAge())
                .state(pet.getState())
                .user(new UserDto(pet.getUser()))
                .build();
*/