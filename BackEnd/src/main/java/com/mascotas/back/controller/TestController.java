package com.mascotas.back.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    @GetMapping("hola")
    public String probando() {
        return "Hola Mundo";
    }

    @Secured("ADMIN")
    @GetMapping("admin")
    public String endpointComprador() {
        return "Hola, soy un Administrador";
    }

    @Secured("USER")
    @GetMapping("user")
    public String endpointVendedor() {
        return "Hola, soy un usuario";
    }

}
