package com.mascotas.back.controller;

import com.mascotas.back.dto.*;
import com.mascotas.back.model.Pet;
import com.mascotas.back.repository.PetRepository;
import com.mascotas.back.service.ImageService;
import com.mascotas.back.service.PetService;
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
@CrossOrigin()
public class PetController {

    private final PetService petService;
    private final PetRepository petRepository;
    private final ImageService imageService;

    @GetMapping("/pets")
    public ResponseEntity<Page<PetResponseDto>> listPets(@PageableDefault(page = 0, size = 4, sort = {"name"}, direction = Sort.Direction.DESC) Pageable pagination){
        return ResponseEntity.ok(petRepository.findAll(pagination).map(PetResponseDto::new));
    }

    @GetMapping("/pet/{id}")
    public ResponseEntity<PetResponseDto> getPet(@PathVariable Long id) {
        PetResponseDto pet = petService.findPetById(id);
        return ResponseEntity.ok(pet);
    }

    @DeleteMapping("/pet/{id}")
    public ResponseEntity<?> deletePet(@PathVariable Long id) {
        petService.deletePetById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/pet")
    public ResponseEntity<PetResponseDto> createPet(@RequestBody PetRequestDto petRequestDto, UriComponentsBuilder uriComponentsBuilder) {
        Pet pet = petService.savePet(petRequestDto);
        imageService.saveImage(petRequestDto.getImage(), pet);
        URI url = uriComponentsBuilder.path("api/v1/pet/{id}").buildAndExpand(pet.getId()).toUri(); // Response header with link Get pet
        PetResponseDto petResponseDto = PetResponseDto
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
        return ResponseEntity.created(url).body(petResponseDto);
    }

    @PutMapping("/pet")
    public ResponseEntity<PetResponseDto> updatePet(@RequestBody PetRequestDto petRequestDto) {
        if (petService.existsById(petRequestDto.getId())) {
            Pet pet = petService.savePet(petRequestDto);
            PetResponseDto petResponseDto = PetResponseDto
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
            return ResponseEntity.ok(petResponseDto);
        } else {
            return null; // Crear excepción personalizada NOT_FOUND (id no existe)
        }
    }

}
