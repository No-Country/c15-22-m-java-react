package com.mascotas.back.serviceImpl;

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

    public void deleteImage(Long id) {
        Optional<Image> respuesta = imageRepository.findById(id);

        if (respuesta.isPresent()) {
            imageRepository.deleteById(id);
        }

    }

    public Image updateImage(Long id, byte[] imageBase64) {

        Image image = new Image();

        Optional<Image> respuesta = imageRepository.findById(id);

        if (respuesta.isPresent()) {
            image = respuesta.get();
            image.setImage(imageBase64);
            return imageRepository.save(image);
        }

        return null;
    }

    public List<Image> listImage(Long id) {

        Optional<Pet> respuesta = petRepository.findById(id);

        if (respuesta.isPresent()) {
            List<Image> images = imageRepository.findAll();
            List<Image> imagesFilter = new ArrayList();
            for (int i = 0; i < images.size(); i++) {

                if (images.get(i).getPet().getId() == id) {
                    imagesFilter.add(images.get(i));
                }

            }
            return imagesFilter;
        }

        return null;

    }

    @Override
    public Image saveImage(byte[] imageBase64, Long id) {
        Pet pet = petRepository.getReferenceById(id);
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

}
