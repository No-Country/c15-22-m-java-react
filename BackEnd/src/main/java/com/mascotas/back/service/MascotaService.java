/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mascotas.back.service;

import com.mascotas.back.dto.PetDto;
import com.mascotas.back.model.Pet;
import java.util.List;


public interface MascotaService {
      
    public List<Pet> listAll();
    public Pet save(PetDto pet);
    public void deleteById(Long id);
    public Pet findById(Long id);
    public boolean exsistById(Long id);
       
}
