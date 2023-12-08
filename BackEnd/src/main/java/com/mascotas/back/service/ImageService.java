package com.mascotas.back.service;

import com.mascotas.back.model.Image;
import com.mascotas.back.model.Pet;
import java.util.List;

public interface ImageService {

    Image saveImage(byte[] imageBase64, Pet pet);
    Image saveImage(byte[] imageBase64, Long id);
    Image updateImage(Long id ,byte[] imageBase64);
    void deleteImage(Long id);
    List<Image> listImage(Long id);
    boolean existsById(Long id);

}
