package com.mascotas.back.security.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {

    @NotBlank(message = "email no puede ser nulo o vacío")
    @Email
    private String email;

    @NotBlank(message = "password no puede ser nulo o vacío")
    @Pattern(regexp = "\\d{8,}") // Solo permite 8 dígitos como mínimo.
    private String password;

}