
package com.mascotas.back.controller;

import com.mascotas.back.dto.UserResponseDto;
import com.mascotas.back.model.User;
import com.mascotas.back.security.jwt.JwtService;
import com.mascotas.back.service.UserService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpHeaders;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins="http://localhost:5173")
public class UserController {

    @Autowired
    private UserService userServ;

    @Autowired
    private JwtService jwtService;

    @GetMapping
    @ResponseBody
    public List<UserResponseDto> getUsers() {
        return userServ.getUsers();
    }

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


    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user) {
        User newUser = userServ.createUser(user);
        return ResponseEntity.ok("Usuario registrado exitosamente.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userServ.deleteUser(id);
        return ResponseEntity.ok("Usuario borrado exitosamente.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {

        UserResponseDto user = userServ.findUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Usuario no encontrado para el ID: " + id);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Optional<User>> getUserByEmail(@PathVariable String email) {
        return ResponseEntity.ok(userServ.findUserByEmail(email));
    }

}
