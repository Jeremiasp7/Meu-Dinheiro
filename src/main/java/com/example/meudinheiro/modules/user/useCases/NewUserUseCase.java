package com.example.meudinheiro.modules.user.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.meudinheiro.modules.user.dto.CreateUserDTO;
import com.example.meudinheiro.modules.user.entities.UserEntity;
import com.example.meudinheiro.modules.user.repositories.UserRepository;

@Service
public class NewUserUseCase {
    
    @Autowired
    private UserRepository userRepository;

    public UserEntity createUser(CreateUserDTO dto) {
        UserEntity user = UserEntity.builder()
            .id(UUID.randomUUID())
            .email(dto.getEmail())
            .password(dto.getPassword())
            .build();
        
        return userRepository.save(user);
    }
}
