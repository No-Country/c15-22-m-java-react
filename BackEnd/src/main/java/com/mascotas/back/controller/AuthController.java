package com.mascotas.back.controller;

import com.mascotas.back.security.dto.AuthResponse;
import com.mascotas.back.security.dto.LoginDto;
import com.mascotas.back.security.dto.RegisterDto;

import com.mascotas.back.security.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("login")
    public ResponseEntity<AuthResponse> login(@RequestBody @Valid LoginDto datos) {
        try {
            return ResponseEntity.ok(authService.login(datos));
        } catch (RuntimeException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("registro")
    public ResponseEntity<AuthResponse> registro(@RequestBody @Valid RegisterDto datos) {
        try {
            return ResponseEntity.ok(authService.registro(datos));
        } catch (RuntimeException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}