/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mascotas.back.service;

import com.mascotas.back.model.User;
import java.util.List;


public interface UserService {
    public List<User> getUsers();
    public User createUser (User user);
    public void deleteUser (Long id);
    public User findUserById (Long id);
}
