package com.mascotas.back.service;

import com.mascotas.back.dto.PetRequestDto;
import com.mascotas.back.dto.PetResponseDto;
import com.mascotas.back.model.Pet;

public interface PetService {

    PetResponseDto findPetById(Long id);
    void deletePetById(Long id);
    Pet savePet(PetRequestDto petRequestDto);
    boolean existsById(Long id);
       
}
