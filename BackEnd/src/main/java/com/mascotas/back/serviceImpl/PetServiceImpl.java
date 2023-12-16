package com.mascotas.back.serviceImpl;

import com.mascotas.back.dto.PetRequestCreateDto;
import com.mascotas.back.dto.PetRequestUpdateDto;
import com.mascotas.back.model.Pet;
import com.mascotas.back.dto.PetResponseCreateDto;
import com.mascotas.back.repository.PetRepository;
import com.mascotas.back.repository.UserRepository;
import com.mascotas.back.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;
    private final UserRepository userRepository;

    @Override
    public PetResponseCreateDto findPetById(Long id) {
        Pet pet = petRepository.findById(id).orElse(null);
        return (pet != null) ? new PetResponseCreateDto(pet) : null;
    }

    @Override
    public void deletePetById(Long id) {
        petRepository.deleteById(id);
    }

    @Override
    public Pet savePet(PetRequestCreateDto petRequestCreateDto) {
        Pet pet = Pet
                .builder()
                .name(petRequestCreateDto.name)
                .description(petRequestCreateDto.description)
                .type(petRequestCreateDto.type)
                .race(petRequestCreateDto.race)
                .age(petRequestCreateDto.age)
                .state(petRequestCreateDto.state)
                .user(userRepository.getReferenceById(petRequestCreateDto.user_id)) // El método getReferenceById() obtiene el usuario igual a user_id.
                .build();
        return petRepository.save(pet);
    }

    @Override
    public Pet savePet(PetRequestUpdateDto petRequestUpdateDto) {
        Pet pet = Pet
                .builder()
                .id(petRequestUpdateDto.id)
                .name(petRequestUpdateDto.name)
                .description(petRequestUpdateDto.description)
                .type(petRequestUpdateDto.type)
                .race(petRequestUpdateDto.race)
                .age(petRequestUpdateDto.age)
                .state(petRequestUpdateDto.state)
                .user(userRepository.getReferenceById(petRequestUpdateDto.user_id)) // El método getReferenceById() obtiene el usuario igual a user_id.
                .build();
        return petRepository.save(pet);
    }

    @Override
    public boolean existsById(Long id) {
        return petRepository.existsById(id);
    }

}
