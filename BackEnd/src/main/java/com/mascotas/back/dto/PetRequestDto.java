package com.mascotas.back.dto;

import com.mascotas.back.enums.StatePet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class PetRequestDto implements Serializable {

    public String name;
    public String description;
    public String type;
    public String race;
    public Integer age;
    public StatePet state;
    public Long user_id;

}
