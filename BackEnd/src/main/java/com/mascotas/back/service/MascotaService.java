/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mascotas.back.service;

import com.mascotas.back.model.Pet;
import java.util.List;


public interface MascotaService {
    
    public List<Pet> verMascotas();
    public void crearMascota (Pet mas);
    public void eliminarMascota (Long id);
    public Pet buscarMascota (Long id);
    
}
