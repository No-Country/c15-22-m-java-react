package com.mascotas.back.dto;

import com.mascotas.back.enums.StatePet;
import com.mascotas.back.model.Pet;
import java.io.Serializable;

import com.mascotas.back.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PetDto implements Serializable {
    public String name;
    public String description;
    public String type;
    public String race;
    public Integer age;
    public StatePet state;
    public UserResponseDto user;
    
    public PetDto(Pet pet){
        this(pet.getName(),
               pet.getDescription(),
               pet.getType(),
               pet.getRace(),
               pet.getAge(),
               pet.getState(),
               new UserResponseDto(pet.getUser())
            );
    }
}

