package com.mascotas.back.dto;

import com.mascotas.back.enums.StatePet;
import com.mascotas.back.model.Pet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

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
    public PetDto(Pet pet){
        this(pet.getName(),
                pet.getDescription(),
                pet.getType(),
                pet.getRace(),
                pet.getAge(),
                pet.getState()
        );
    }
}
