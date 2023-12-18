package com.mascotas.back.dto;

import com.mascotas.back.model.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserResponseDto implements Serializable {

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private List<PetDto> pets;

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.pets = user.getPets().stream().map(PetDto::new).toList();
    }

}