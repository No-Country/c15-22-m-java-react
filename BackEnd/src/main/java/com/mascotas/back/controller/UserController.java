
package com.mascotas.back.controller;

import com.mascotas.back.dto.UserResponseDto;
import com.mascotas.back.model.User;
import com.mascotas.back.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@CrossOrigin()
public class UserController {

    @Autowired
    private UserService userServ;

    @GetMapping
    @ResponseBody
    public List<UserResponseDto> getUsers() {
        return userServ.getUsers();
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
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Usuario no encontrado para el ID: " + id);
        }

    }


}
