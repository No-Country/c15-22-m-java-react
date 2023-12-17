package com.mascotas.back.serviceImpl;

import com.mascotas.back.model.User;
import com.mascotas.back.repository.UserRepository;
import com.mascotas.back.service.UserService;

import java.util.Optional;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    public final UserRepository userRepo;

    @Override
    public boolean existsByEmail (String email){
        return userRepo.existsByEmail(email);
    }

    @Override
    public boolean existsById(Long user_id) {
        return userRepo.existsById(user_id);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }

}