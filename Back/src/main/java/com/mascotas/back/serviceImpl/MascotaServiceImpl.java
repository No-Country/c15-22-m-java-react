/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mascotas.back.serviceImpl;

import com.mascotas.back.model.Mascota;
import com.mascotas.back.repository.MascotaRepository;
import com.mascotas.back.service.MascotaService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MascotaServiceImpl implements MascotaService {
    
    
    public final MascotaRepository mrepo;

    @Override
    public List<Mascota> verMascotas() {
        return mrepo.findAll();
    }

    @Override
    public void crearMascota(Mascota mas) {
        mrepo.save(mas);
    }

    @Override
    public void eliminarMascota(Long id) {
        mrepo.deleteById(id);
    }

    @Override
    public Mascota buscarMascota(Long id) {
        return mrepo.findById(id).orElse(null);
    }
    
}
