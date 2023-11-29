/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mascotas.back.dto;

import com.mascotas.back.enums.StatePet;
import com.mascotas.back.model.Pet;
import com.mascotas.back.model.User;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author mathi
 */
@Getter
@Setter
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
    public User user;
    
    public PetDto(Pet pet){
        this(pet.getId(),
               pet.getName(),
               pet.getDescription(),
               pet.getType(),
               pet.getRace(),
               pet.getAge(),
               pet.getState(),
               pet.getUser()       
        
    );
    }
}


/*

public class DoctorDTO implements Serializable {
    public Long id;
        public String name;
        public String specialization;
        public String document;
        public String email;

    public DoctorDTO( Doctor doctor ) { // Solo declarar lo que se debe enviar en un get
        this( doctor.getId(), doctor.getName(), doctor.getSpecialization().toString(), doctor.getDocument(), doctor.getEmail());
    }
}
*/

