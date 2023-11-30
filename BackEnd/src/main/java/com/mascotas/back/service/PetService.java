package com.mascotas.back.service;

import com.mascotas.back.dto.PetDto;
import com.mascotas.back.model.Pet;
import java.util.List;

public interface PetService {
      
    List<Pet> listAll();
    Pet save(PetDto pet);
    void deleteById(Long id);
    Pet findById(Long id);
    boolean exsistById(Long id);
       
}
