package com.mascotas.back.controller;

import com.mascotas.back.dto.PetResponseDto;
import com.mascotas.back.repository.PetRepository;
import com.mascotas.back.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class PetController {
    private final PetService petService;
    private final PetRepository petRepository;

    @GetMapping("/pets")
    public ResponseEntity<Page<PetResponseDto>> listPets(@PageableDefault(page = 0, size = 2, sort = {"name"}) Pageable paginacion){
        return ResponseEntity.ok(petRepository.findAll(paginacion).map(PetResponseDto::new));
    }
    
}
