package com.mascotas.back.service;

import com.mascotas.back.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findUserByEmail(String email);

    boolean existsByEmail(String email); // TODO. Para recuperar la contraseña

    boolean existsById(Long user_id);
}