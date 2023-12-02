package com.mascotas.back.repository;

import com.mascotas.back.enums.RolUser;
import com.mascotas.back.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepositoty extends JpaRepository<Rol, Long> {

    Optional<Rol> findByRolName(RolUser rolUser);
}
