/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mascotas.back.service;

import com.mascotas.back.model.Mascota;
import java.util.List;


public interface MascotaService {
    
    public List<Mascota> verMascotas();
    public void crearMascota (Mascota mas);
    public void eliminarMascota (Long id);
    public Mascota buscarMascota (Long id);
    
}
