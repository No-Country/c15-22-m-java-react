package com.mascotas.back.security.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {

    private String name;

    private String lastName;

    private String phone;

    private String email;

    private String password;

    private String rol;
}
