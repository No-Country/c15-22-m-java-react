package com.mascotas.back.security.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {

    @NotBlank(message = "name no puede ser nulo o vacío")
    private String name;

    @NotBlank(message = "lastName no puede ser nulo o vacío")
    private String lastName;

    @NotBlank(message = "phone no puede ser nulo o vacío")
    private String phone;

    @NotBlank(message = "email no puede ser nulo o vacío")
    @Email
    private String email;

    @NotBlank(message = "password no puede ser nulo o vacío")
    @Pattern(regexp = "[a-zA-Z0-9]{8,}") // Solo permite 8 dígitos como mínimo.
    private String password;
    @NotBlank(message = "rol no puede ser nulo o vacío")
    private String rol; // TODO. No debería ser de tipo RoleUser ??? | Output error with data invalid: "No enum constant com.mascotas.back.enums.RoleUser.sadsada"
}
