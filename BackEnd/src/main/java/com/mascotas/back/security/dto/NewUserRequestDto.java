package com.mascotas.back.security.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class NewUserRequestDto {

    private String name;

    private String lastName;

    private String phone;

    private String email;

    private String password;

    private Set<String> roles = new HashSet<>();



}
