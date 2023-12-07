package com.mascotas.back.service;

import com.mascotas.back.model.Image;
import com.mascotas.back.model.Pet;

public interface ImageService {

    Image saveImage(byte[] imageBase64, Pet pet);

}
