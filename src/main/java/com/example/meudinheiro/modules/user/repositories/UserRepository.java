package com.example.meudinheiro.modules.user.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.meudinheiro.modules.user.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    
    public Optional<UserEntity> findByEmail(String email);
}
