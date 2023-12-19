package com.mascotas.back.dto;

import com.mascotas.back.enums.StatePet;
import com.mascotas.back.model.Image;
import com.mascotas.back.model.Pet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PetDto implements Serializable {
    public Long id;
    public String name;
    public String description;
    public String type;
    public String race;
    public Integer age;
    public StatePet state;
    public List<ImageResponseDto> images;
    public PetDto(Pet pet){
        this(pet.getId(),
                pet.getName(),
                pet.getDescription(),
                pet.getType(),
                pet.getRace(),
                pet.getAge(),
                pet.getState(),
                pet.getImages().stream().map(  // Convertir una lista de tipo Image a lista de tipo ImageResponseDto con patrón Builder
                        image -> ImageResponseDto
                                .builder()
                                .image_id(image.getId())
                                .imageBase64(image.getImage())
                                .build()
                ).toList()


        );
    }
}
