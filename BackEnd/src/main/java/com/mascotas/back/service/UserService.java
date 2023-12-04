/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mascotas.back.service;

import com.mascotas.back.dto.UserResponseDto;
import com.mascotas.back.model.User;
import java.util.List;


public interface UserService {
    public List<UserResponseDto> getUsers();
    public User createUser (User user);
    public void deleteUser (Long id);
    public UserResponseDto findUserById (Long id);
    public User findUserByEmail (String email);
}
