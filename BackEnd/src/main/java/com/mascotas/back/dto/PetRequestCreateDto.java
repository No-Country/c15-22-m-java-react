package com.mascotas.back.dto;

import com.mascotas.back.enums.StatePet;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class PetRequestCreateDto implements Serializable {

    @NotBlank(message = "name no puede ser nulo o vacío")
    @Size(min = 2, max = 25)
    public String name;

    @NotBlank(message = "description no puede ser nulo o vacío")
    @Size(min = 10, max = 10000)
    public String description;

    @NotBlank(message = "description no puede ser nulo o vacío")
    public String type;

    @NotBlank(message = "race no puede ser nulo o vacío")
    public String race;

    @NotNull(message = "age no puede ser nulo")
    public Integer age;

    @NotNull(message = "state no puede ser nulo o vacío")
    public StatePet state;

    @NotNull(message = "user_id no puede ser nulo")
    public Long user_id;

    @NotEmpty(message = "image no puede ser nulo o vacío") // TODO. Validar
    public byte[] image;

}
