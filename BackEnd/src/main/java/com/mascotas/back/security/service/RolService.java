package com.mascotas.back.security.service;


import com.mascotas.back.enums.RolUser;
import com.mascotas.back.model.Rol;
import com.mascotas.back.repository.RolRepositoty;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class RolService {

    @Autowired
    RolRepositoty rolRepositoty;

    public Optional<Rol> getByRolName(RolUser rolUser) {
        return rolRepositoty.findByRolName(rolUser);
    }

    public void saveRol(Rol rol) {
        rolRepositoty.save(rol);
    }
}
