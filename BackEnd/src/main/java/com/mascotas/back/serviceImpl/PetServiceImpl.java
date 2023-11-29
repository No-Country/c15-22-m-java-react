/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mascotas.back.serviceImpl;


import com.mascotas.back.dto.PetDto;
import com.mascotas.back.model.Pet;
import com.mascotas.back.repository.PetRepository;
import com.mascotas.back.service.MascotaService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements MascotaService {
    
    
    
    
       
    private final PetRepository petRepository;
  
    @Override
    public List<Pet> listAll() {
        return petRepository.findAll();
    }

    @Override
    public Pet save(PetDto mas) {
     Pet pet =new Pet();
     pet.setName(mas.getName());
     pet.setDescription(mas.getDescription());
     pet.setRace(mas.getRace());
     pet.setAge(mas.getAge());
     pet.setRace(mas.getRace());
     pet.setType(mas.getType());
     
     return petRepository.save(pet);
    }

    @Override
    public void deleteById(Long id) {
        petRepository.deleteById(id);
    }

    @Override
    public Pet findById(Long id) {
        return petRepository.findById(id).orElse(null);
    }
    
   


    @Override
    public boolean exsistById(Long id) {
      return petRepository.existsById(id);

    }
    
    
}
