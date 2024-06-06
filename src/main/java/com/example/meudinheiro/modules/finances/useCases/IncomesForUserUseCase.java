package com.example.meudinheiro.modules.finances.useCases;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.meudinheiro.modules.finances.entities.IncomesEntity;
import com.example.meudinheiro.modules.finances.repositories.IncomesRepository;
import com.example.meudinheiro.modules.user.entities.UserEntity;

@Service
public class IncomesForUserUseCase {
    
    @Autowired
    private IncomesRepository incomesRepository;

    public List<IncomesEntity> getIncomesForUser(UserEntity user, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return incomesRepository.findByUserAndDateBetween(user, startDateTime, endDateTime);
    }
}
