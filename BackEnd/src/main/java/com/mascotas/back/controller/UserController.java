package com.mascotas.back.controller;

import com.mascotas.back.dto.UserResponseDto;
import com.mascotas.back.model.User;
import com.mascotas.back.security.jwt.JwtService;
import com.mascotas.back.service.UserService;

import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin(origins= {"http://localhost:5173", "https://c15-22-m-java-react.vercel.app/,https://c15-22-m-java-react.vercel.app/"})
public class UserController {

    private final UserService userServ;
    private final JwtService jwtService;

    @GetMapping("/profile")
    public ResponseEntity<?> userProfile(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        String userName = null;
        if (StringUtils.hasText(token) && token.startsWith("Bearer ")) {
            userName = jwtService.getUsernameFromToken(
                    token.substring(7)
            );
        }
        Optional<User> user = userServ.findUserByEmail(userName);
        if (user.isPresent()) {
            UserResponseDto userProfile = new UserResponseDto(user.get());
            return ResponseEntity.ok(userProfile);
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Usuario no encontrado");
        }
    }

}