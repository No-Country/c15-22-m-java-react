package com.mascotas.back.dto;

import com.mascotas.back.enums.RolUser;
import com.mascotas.back.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class UserResponseDto {

    private String name;
    private String lastName;
    private String phone;
    private String email;
    private RolUser rol;

    public UserResponseDto(User user) {
        this.name= user.getName();
        this.lastName = user.getLastName();
        this.phone = user.getPhone();
        this.email = user.getEmail();
        this.rol = user.getRol();
    }
}
