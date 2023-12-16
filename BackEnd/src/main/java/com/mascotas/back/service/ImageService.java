package com.mascotas.back.service;

import com.mascotas.back.dto.ImageDto;
import com.mascotas.back.model.Image;
import com.mascotas.back.model.Pet;
import java.util.List;

public interface ImageService {

    Image saveImage(byte[] imageBase64, Pet pet);
    Image saveImage(byte[] imageBase64, Long pet_id);
    Image updateImage(byte[] imageBase64, Long image_id);
    void deleteImage(Long id);
    List<Image> listImage(Long pet_id);
    boolean existsById(Long id);
    ImageDto findImageById(Long imageId);
}
