package com.mascotas.back.dto;

import com.mascotas.back.enums.StatePet;
import com.mascotas.back.model.Pet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PetResponseUpdateDto {

    public Long id;
    public String name;
    public String description;
    public String type;
    public String race;
    public Integer age;
    public StatePet state;
    public UserDto user;

    public PetResponseUpdateDto(Pet pet){
        this(pet.getId(),
                pet.getName(),
                pet.getDescription(),
                pet.getType(),
                pet.getRace(),
                pet.getAge(),
                pet.getState(),
                new UserDto(pet.getUser())
        );
    }

}
