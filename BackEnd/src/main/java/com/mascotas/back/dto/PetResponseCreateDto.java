package com.mascotas.back.dto;

import com.mascotas.back.enums.StatePet;
import com.mascotas.back.model.Pet;
import java.io.Serializable;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PetResponseCreateDto implements Serializable {

    public Long id;
    public String name;
    public String description;
    public String type;
    public String race;
    public Integer age;
    public StatePet state;
    public UserDto user;
    public ImageDto image;

    public PetResponseCreateDto(Pet pet){
        this(pet.getId(),
               pet.getName(),
               pet.getDescription(),
               pet.getType(),
               pet.getRace(),
               pet.getAge(),
               pet.getState(),
               new UserDto(pet.getUser()),
               new ImageDto(pet.getImages()) // Se le pasa el argumento Set<Images>
        );
    }

}

