package com.mascotas.back.controller;

import com.mascotas.back.dto.*;
import com.mascotas.back.exception.ResourceNotFoundException;
import com.mascotas.back.model.Image;
import com.mascotas.back.model.Pet;
import com.mascotas.back.repository.PetRepository;
import com.mascotas.back.service.ImageService;
import com.mascotas.back.service.PetService;
import com.mascotas.back.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@CrossOrigin(origins= {"http://localhost:5173", "https://c15-22-m-java-react.vercel.app/,https://c15-22-m-java-react.vercel.app/"})
public class PetController {

    private final PetService petService;
    private final PetRepository petRepository;
    private final ImageService imageService;
    private final UserService userService;

    @GetMapping("/pets")
    public ResponseEntity<Page<PetResponseCreateDto>> listPets(Pageable pagination){
        List<PetResponseCreateDto> petList = petRepository.findAll(pagination).map(PetResponseCreateDto::new).toList();
        if (petList.isEmpty()) throw new ResourceNotFoundException("pets");
        return ResponseEntity.ok(petRepository.findAll(pagination).map(PetResponseCreateDto::new));
    }

    @GetMapping("/pet/{id}")
    public ResponseEntity<PetResponseCreateDto> getPet(@PathVariable Long id) {
        PetResponseCreateDto pet = petService.findPetById(id);
        if (pet == null) throw new ResourceNotFoundException("pet", "id", id);
        return ResponseEntity.ok(pet);
    }

    @DeleteMapping("/pet/{id}")
    public ResponseEntity<?> deletePet(@PathVariable Long id) {
        if (!petService.existsById(id)) throw new ResourceNotFoundException("pet", "id", id);
        petService.deletePetById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/pet")
    public ResponseEntity<PetResponseCreateDto> createPet(@RequestBody @Valid PetRequestCreateDto petRequestCreateDto, UriComponentsBuilder uriComponentsBuilder) {
        if (!userService.existsById(petRequestCreateDto.user_id)) throw new ResourceNotFoundException("user", "user_id", petRequestCreateDto.user_id);
        Pet pet = petService.savePet(petRequestCreateDto);
        Image image = imageService.saveImage(petRequestCreateDto.getImage(), pet);
        URI url = uriComponentsBuilder.path("api/v1/pet/{id}").buildAndExpand(pet.getId()).toUri();
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
            throw new ResourceNotFoundException("pet", "id", petRequestUpdateDto.getId());
        }
    }

}