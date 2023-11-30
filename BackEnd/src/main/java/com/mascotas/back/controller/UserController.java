
package com.mascotas.back.controller;

import com.mascotas.back.dto.UserResponseDto;
import com.mascotas.back.model.User;
import com.mascotas.back.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
@CrossOrigin ()
public class UserController {
    
    @Autowired
    private UserService userServ;
    
    @GetMapping
    @ResponseBody
    public List <UserResponseDto> getUsers(){
        return userServ.getUsers();
    }
    
    @PostMapping
    public User createUser (@RequestBody User user){
        return userServ.createUser(user);
    }
    
    @DeleteMapping ("/{id}")
    public void deleteUser (@PathVariable Long id){
        userServ.deleteUser(id);
    }
    
    @GetMapping("/{id}")
    public User getUserById (@PathVariable Long id){
        return userServ.findUserById(id);
    }
    
    
}
