package com.mascotas.back.dto;

import com.mascotas.back.enums.RolUser;
import com.mascotas.back.model.Rol;
import com.mascotas.back.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {
    private String name;
    private String lastName;
    private String email;
    private String phone;
    public UserDto(User user) {
        this(user.getName(), user.getLastName(), user.getEmail(), user.getPhone());
    }
}
