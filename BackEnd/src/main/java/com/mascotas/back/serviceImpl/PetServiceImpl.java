package com.mascotas.back.serviceImpl;

import com.mascotas.back.dto.PetRequestDto;
import com.mascotas.back.model.Pet;
import com.mascotas.back.dto.PetResponseDto;
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
    public PetResponseDto findPetById(Long id) {
        Pet pet = petRepository.findById(id).orElse(null);
        return (pet != null) ? new PetResponseDto(pet) : null;
    }

    @Override
    public void deletePetById(Long id) {
        petRepository.deleteById(id);
    }

    @Override
    public Pet savePet(PetRequestDto petRequestDto) {
        Pet pet = Pet
                .builder()
                .name(petRequestDto.name)
                .description(petRequestDto.description)
                .type(petRequestDto.type)
                .race(petRequestDto.race)
                .age(petRequestDto.age)
                .state(petRequestDto.state)
                .user(userRepository.getReferenceById(petRequestDto.user_id)) // El método getReferenceById() obtiene el usuario correspondiente al user_id del petRequestCreationDto.
                .build();
        return petRepository.save(pet);
    }

    @Override
    public boolean existsById(Long id) {
        return petRepository.existsById(id);
    }

}
