package com.example.meudinheiro.modules.finances.useCases;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.meudinheiro.modules.finances.dto.CreateExpensesDTO;
import com.example.meudinheiro.modules.finances.entities.ExpensesEntity;
import com.example.meudinheiro.modules.finances.repositories.ExpensesRepository;
import com.example.meudinheiro.modules.user.entities.UserEntity;

@Service
public class ExpensesForUserUseCase {
    
    @Autowired
    private ExpensesRepository expensesRepository;

    public List<CreateExpensesDTO> getExpensesForUser(UserEntity user, LocalDateTime startDate, LocalDateTime endDate) {
        List<ExpensesEntity> expenses = expensesRepository.findByUserAndDateBetween(user, startDate, endDate);
        return expenses.stream().map(expense -> CreateExpensesDTO.builder()
            .expensesDescription(expense.getDescription())
            .expensesAmount(expense.getAmount())
            .expensesDateTime(expense.getDate())
            .categoryName(expense.getCategory())
            .build())
        .collect(Collectors.toList());
            
    }
}
