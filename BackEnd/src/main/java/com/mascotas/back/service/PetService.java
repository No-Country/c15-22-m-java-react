package com.mascotas.back.service;

import com.mascotas.back.dto.PetRequestCreateDto;
import com.mascotas.back.dto.PetRequestUpdateDto;
import com.mascotas.back.dto.PetResponseCreateDto;
import com.mascotas.back.model.Pet;

public interface PetService {

    PetResponseCreateDto findPetById(Long id);
    void deletePetById(Long id);
    Pet savePet(PetRequestCreateDto petRequestCreateDto);
    Pet savePet(PetRequestUpdateDto petRequestUpdateDto);
    boolean existsById(Long id);
       
}