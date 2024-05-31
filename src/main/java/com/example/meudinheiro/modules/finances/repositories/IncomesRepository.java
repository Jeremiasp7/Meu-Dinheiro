package com.example.meudinheiro.modules.finances.repositories;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.meudinheiro.modules.finances.entities.IncomesEntity;
import com.example.meudinheiro.modules.user.entities.UserEntity;

public interface IncomesRepository extends JpaRepository<IncomesEntity, UUID>{
    
    List<IncomesEntity> findUserAndDateBetween(UserEntity user, LocalDateTime startDate, LocalDateTime endDate);
}
