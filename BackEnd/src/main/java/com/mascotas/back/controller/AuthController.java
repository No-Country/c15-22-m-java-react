package com.mascotas.back.controller;

import com.mascotas.back.security.dto.AuthResponse;
import com.mascotas.back.security.dto.LoginDto;
import com.mascotas.back.security.dto.RegisterDto;

import com.mascotas.back.security.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin ()
public class AuthController {

    private final AuthService authService;
    
    @Autowired
    private JavaMailSender mail;
    
    @GetMapping("enviar")
    public void enviarCorreo(){
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo("jean.yantas@gmail.com");
        email.setFrom("ramon.jose.cruz187@gmail.com");
        email.setSubject("Mensaje de prueba 1");
        email.setText("mensaje de prueba");
        
        mail.send(email);
        
       
    }
    
    @GetMapping("prueba")
    public String prueba(){
        return "prueba";
    }

    @PostMapping("login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginDto datos) {
        try {
            return ResponseEntity.ok(authService.login(datos));
        } catch (RuntimeException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("registro")
    public ResponseEntity<AuthResponse> registro(@RequestBody RegisterDto datos) {
        try {
            return ResponseEntity.ok(authService.registro(datos));
        } catch (RuntimeException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
