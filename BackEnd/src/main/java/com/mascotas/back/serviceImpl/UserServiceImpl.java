/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mascotas.back.serviceImpl;

import com.mascotas.back.dto.UserResponseDto;
import com.mascotas.back.model.User;
import com.mascotas.back.repository.UserRepository;
import com.mascotas.back.service.UserService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository userRepo;

    @Override
    public List<UserResponseDto> getUsers() {
        List<User> users = userRepo.findAll();
        return users.stream()
                .map(UserResponseDto::new).toList();
    }

    @Override
    public User createUser(User user) {
        return userRepo.saveAndFlush(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public UserResponseDto findUserById(Long id) {

        Optional<User> userOptional = userRepo.findById(id);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return  new UserResponseDto(user);
        } else {
            return null;
        }
    }

}
