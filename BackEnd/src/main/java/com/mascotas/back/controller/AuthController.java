package com.mascotas.back.controller;

import com.mascotas.back.enums.RolUser;
import com.mascotas.back.model.Rol;
import com.mascotas.back.model.User;
import com.mascotas.back.security.Message;
import com.mascotas.back.security.dto.JwtDto;
import com.mascotas.back.security.dto.LoginRequestDto;
import com.mascotas.back.security.dto.NewUserRequestDto;
import com.mascotas.back.security.jwt.JwtProvider;
import com.mascotas.back.security.service.RolService;
import com.mascotas.back.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;


    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NewUserRequestDto newUserRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity(new Message("Campos mal puestos o email invalido"), HttpStatus.BAD_REQUEST);

        if (userService.existsByEmail(newUserRequest.getEmail()))
            return new ResponseEntity(new Message("Ese email ya existe"), HttpStatus.BAD_REQUEST);

        User user = new User(newUserRequest.getName(),
                newUserRequest.getLastName(),
                newUserRequest.getPhone(),
                newUserRequest.getEmail(),
                passwordEncoder.encode(newUserRequest.getPassword())
        );

        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolName(RolUser.ROL_USER).get());

        if (newUserRequest.getRoles().contains("admin"))
            roles.add(rolService.getByRolName(RolUser.ROL_ADMIN).get());
        user.setRol(roles);
        userService.createUser(user);

        return new ResponseEntity(new Message("Usuario guardado"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginRequestDto loginRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity(new Message("Campos mal puestos"), HttpStatus.BAD_REQUEST);

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateToken(authentication);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());

        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
}