package com.mascotas.back.serviceImpl;

import com.mascotas.back.dto.ImageDto;
import com.mascotas.back.model.Image;
import com.mascotas.back.model.Pet;
import com.mascotas.back.repository.ImageRepository;
import com.mascotas.back.repository.PetRepository;
import com.mascotas.back.service.ImageService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;
    private final PetRepository petRepository;

    @Override
    public Image saveImage(byte[] imageBase64, Pet pet) {
        Image image = Image
                .builder()
                .image(imageBase64) // Se asigna la imagen en base64
                .pet(pet) // Se asigna la mascota
                .build();
        return imageRepository.save(image);
    }

    @Override
    public void deleteImage(Long id) {
        Optional<Image> respuesta = imageRepository.findById(id);
        if (respuesta.isPresent()) {
            imageRepository.deleteById(id);
        }
    }

    @Override
    public Image updateImage(byte[] imageBase64, Long image_id) {
        Image image = new Image();
        Optional<Image> respuesta = imageRepository.findById(image_id);
        if (respuesta.isPresent()) {
            image = respuesta.get();
            image.setImage(imageBase64);
            return imageRepository.save(image);
        }
        return null;
    }

    @Override
    public List<Image> listImage(Long pet_id) {
        Optional<Pet> pet = petRepository.findById(pet_id);
        if (pet.isPresent()) {
            List<Image> images = imageRepository.findAll();
            List<Image> imagesFilter = new ArrayList();
            for (int i = 0; i < images.size(); i++) {
                if (images.get(i).getPet().getId() == pet_id) {
                    imagesFilter.add(images.get(i));
                }
            }
            return imagesFilter;
        }
        return null;
    }

    @Override
    public Image saveImage(byte[] imageBase64, Long pet_id) {
        Pet pet = petRepository.getReferenceById(pet_id);
        Image image = Image
                .builder()
                .image(imageBase64) // Se asigna la imagen en base64
                .pet(pet) // Se asigna la mascota
                .build();
        return imageRepository.save(image);
    }
    
    @Override
    public boolean existsById(Long id) {
        return imageRepository.existsById(id);
    }

    @Override
    public ImageDto findImageById(Long imageId) {
        Image image = imageRepository.findById(imageId).orElse(null);
        return (image != null) ? new ImageDto(image) : null;
    }

}