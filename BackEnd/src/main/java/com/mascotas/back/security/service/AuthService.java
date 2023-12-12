package com.mascotas.back.security.service;

import java.util.Optional;

import com.mascotas.back.enums.RoleUser;
import com.mascotas.back.model.User;
import com.mascotas.back.repository.UserRepository;
import com.mascotas.back.security.dto.AuthResponse;
import com.mascotas.back.security.dto.LoginDto;
import com.mascotas.back.security.dto.RegisterDto;
import com.mascotas.back.security.jwt.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginDto datos) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(datos.getEmail(), datos.getPassword()));
        UserDetails user = userRepository.findByEmail(datos.getEmail()).orElseThrow();
        String token = jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public AuthResponse registro(RegisterDto datos) {

        Optional<User> userOptional = userRepository.findByEmail(datos.getEmail());
        if (userOptional.isPresent()) {
            throw new RuntimeException("Ya existe un usuario con ese email");
        }

        User user = User.builder()
                .name(datos.getName())
                .lastName(datos.getLastName())
                .email(datos.getEmail())
                .password(passwordEncoder.encode(datos.getPassword()))
                .phone(datos.getPhone())
                .role(RoleUser.valueOf("USER"))
                .build();

        userRepository.save(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }
}

