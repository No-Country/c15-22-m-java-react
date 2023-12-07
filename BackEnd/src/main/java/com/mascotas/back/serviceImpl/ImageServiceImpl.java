package com.mascotas.back.serviceImpl;

import com.mascotas.back.model.Image;
import com.mascotas.back.model.Pet;
import com.mascotas.back.repository.ImageRepository;
import com.mascotas.back.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;
    @Override
    public Image saveImage(byte[] imageBase64, Pet pet) {
        Image image = Image
                .builder()
                .image(imageBase64) // Se asigna la imagen en base64
                .pet(pet) // Se asigna la mascota
                .build();
        return imageRepository.save(image);
    }

}
