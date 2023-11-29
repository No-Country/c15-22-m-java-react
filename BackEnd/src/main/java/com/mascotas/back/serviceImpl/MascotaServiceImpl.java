/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mascotas.back.serviceImpl;

import com.mascotas.back.model.Pet;
import com.mascotas.back.repository.PetRepository;
import com.mascotas.back.service.MascotaService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MascotaServiceImpl implements MascotaService {
    
    
    public final PetRepository mrepo;

    @Override
    public List<Pet> verMascotas() {
        return mrepo.findAll();
    }

    @Override
    public void crearMascota(Pet mas) {
        mrepo.save(mas);
    }

    @Override
    public void eliminarMascota(Long id) {
        mrepo.deleteById(id);
    }

    @Override
    public Pet buscarMascota(Long id) {
        return mrepo.findById(id).orElse(null);
    }
    
}
