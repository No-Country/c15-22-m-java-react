package com.mascotas.back.controller;

import com.mascotas.back.dto.*;
import com.mascotas.back.model.Image;
import com.mascotas.back.model.Pet;
import com.mascotas.back.repository.PetRepository;
import com.mascotas.back.service.ImageService;
import com.mascotas.back.service.PetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@CrossOrigin(origins="http://localhost:5173")
public class PetController {

    private final PetService petService;
    private final PetRepository petRepository;
    private final ImageService imageService;

    @GetMapping("/pets")
    public ResponseEntity<Page<PetResponseCreateDto>> listPets(@PageableDefault(page = 0, size = 4, sort = {"name"}, direction = Sort.Direction.DESC) Pageable pagination){
        return ResponseEntity.ok(petRepository.findAll(pagination).map(PetResponseCreateDto::new));
    }

    @GetMapping("/pet/{id}")
    public ResponseEntity<PetResponseCreateDto> getPet(@PathVariable Long id) {
        PetResponseCreateDto pet = petService.findPetById(id);
        return ResponseEntity.ok(pet);
    }

    @DeleteMapping("/pet/{id}")
    public ResponseEntity<?> deletePet(@PathVariable Long id) {
        petService.deletePetById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/pet")
    public ResponseEntity<PetResponseCreateDto> createPet(@RequestBody @Valid PetRequestCreateDto petRequestCreateDto, UriComponentsBuilder uriComponentsBuilder) {
        Pet pet = petService.savePet(petRequestCreateDto);
        Image image = imageService.saveImage(petRequestCreateDto.getImage(), pet);
        URI url = uriComponentsBuilder.path("api/v1/pet/{id}").buildAndExpand(pet.getId()).toUri(); // Response header with link Get pet
        PetResponseCreateDto petResponseCreateDto = PetResponseCreateDto
                .builder()
                .id(pet.getId())
                .name(pet.getName())
                .description(pet.getDescription())
                .type(pet.getType())
                .race(pet.getRace())
                .age(pet.getAge())
                .state(pet.getState())
                .user(new UserDto(pet.getUser()))
                .image(new ImageDto(image.getImage())) // Para cambiar el doble objeto anidado en la respuesta image: { imageBase64: { } } crear otro DTO response y en el campo image que sea de tipo byte[]
                .build();
        return ResponseEntity.created(url).body(petResponseCreateDto);
    }

    @PutMapping("/pet")
    public ResponseEntity<PetResponseUpdateDto> updatePet(@RequestBody @Valid PetRequestUpdateDto petRequestUpdateDto) {
        if (petService.existsById(petRequestUpdateDto.getId())) {
            Pet pet = petService.savePet(petRequestUpdateDto);
            PetResponseUpdateDto petResponseUpdateDto = PetResponseUpdateDto
                    .builder()
                    .id(pet.getId())
                    .name(pet.getName())
                    .description(pet.getDescription())
                    .type(pet.getType())
                    .race(pet.getRace())
                    .age(pet.getAge())
                    .state(pet.getState())
                    .user(new UserDto(pet.getUser()))
                    .build();
            return ResponseEntity.ok(petResponseUpdateDto);
        } else {
            return null; // Crear excepción personalizada NOT_FOUND (id no existe)
        }
    }

}
