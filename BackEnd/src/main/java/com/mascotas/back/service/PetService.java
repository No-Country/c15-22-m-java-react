package com.mascotas.back.service;

import com.mascotas.back.dto.PetRequestCreationDto;
import com.mascotas.back.dto.PetResponseDto;
import com.mascotas.back.model.Pet;

public interface PetService {

    PetResponseDto findPetById(Long id);
    void deletePetById(Long id);
    Pet savePet(PetRequestCreationDto petRequestCreationDto);
    boolean existsById(Long id);
       
}
