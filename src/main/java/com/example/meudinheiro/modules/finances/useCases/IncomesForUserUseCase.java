package com.example.meudinheiro.modules.finances.useCases;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.meudinheiro.modules.finances.dto.CreateIncomeDTO;
import com.example.meudinheiro.modules.finances.entities.IncomesEntity;
import com.example.meudinheiro.modules.finances.repositories.IncomesRepository;
import com.example.meudinheiro.modules.user.entities.UserEntity;

@Service
public class IncomesForUserUseCase {
    
    @Autowired
    private IncomesRepository incomesRepository;

    public List<CreateIncomeDTO> getIncomesForUser(UserEntity user, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        List<IncomesEntity> incomes = incomesRepository.findByUserAndDateBetween(user, startDateTime, endDateTime);
        return incomes.stream().map(income -> CreateIncomeDTO.builder()
            .incomesDescription(income.getDescription())
            .incomesAmount(income.getAmount())
            .incomesDateTime(income.getDate())
            .categoryName(income.getCategory())
            .build())
        .collect(Collectors.toList());  
    }
}
