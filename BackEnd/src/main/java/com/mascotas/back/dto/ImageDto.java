/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mascotas.back.dto;

import com.mascotas.back.model.Image;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 *
 * @author mathi
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImageDto implements Serializable {

    public byte[] imageBase64;

    public ImageDto(Image image) {
        this(image.getImage()
        );
    }
}
