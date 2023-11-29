/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mascotas.back.controller;

import com.mascotas.back.dto.PetDto;
import com.mascotas.back.model.Pet;
import com.mascotas.back.serviceImpl.PetServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin ()
public class Controller {
    
    @Autowired
    private PetServiceImpl mserv;
    
    @GetMapping ("/prueba")
    public String prueba(){
        return "Hola!!!";
    }
    
    
    @PostMapping ("/nueva/mascota")
    public void nuevaMascota (@RequestBody PetDto mas){
        mserv.save(mas);
    }
    
    @GetMapping ("/ver/mascotas")
    @ResponseBody
    public List<Pet> listAll(){
        return mserv.listAll();
    }
    
    
    
}
