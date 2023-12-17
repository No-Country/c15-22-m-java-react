package com.mascotas.back.dto;

import com.mascotas.back.model.Image;
import java.io.Serializable;
import java.util.Set;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImageDto implements Serializable {

    @NotEmpty(message = "image no puede ser nulo o vacío")
    public byte[] imageBase64;

    public ImageDto(Image image) {
        this(image.getImage());
    }

    public ImageDto(Set<Image> images) {
        this(images.isEmpty() ? null : images.stream().findFirst().get()); // Se controla cuando images es []
    }

}