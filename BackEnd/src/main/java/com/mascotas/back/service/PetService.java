package com.mascotas.back.service;

import com.mascotas.back.dto.PetResponseDto;
import com.mascotas.back.model.Pet;
import java.util.List;

public interface PetService {
      
    List<Pet> listAll();
    Pet save(PetResponseDto pet);
    void deleteById(Long id);
    Pet findById(Long id);
    boolean exsistById(Long id);
       
}
