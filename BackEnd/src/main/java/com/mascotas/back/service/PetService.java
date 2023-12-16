package com.mascotas.back.service;

import com.mascotas.back.dto.PetRequestUpdateDto;
import com.mascotas.back.dto.PetResponseDto;
import com.mascotas.back.model.Pet;

public interface PetService {

    PetResponseDto findPetById(Long id);
    void deletePetById(Long id);
    Pet savePet(PetRequestUpdateDto petRequestUpdateDto);
    boolean existsById(Long id);
       
}
