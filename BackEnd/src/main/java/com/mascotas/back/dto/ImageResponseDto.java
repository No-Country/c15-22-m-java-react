package com.mascotas.back.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImageResponseDto implements Serializable {

    public Long image_id;
    public byte[] imageBase64;

}
