package com.example.meudinheiro.modules.finances.useCases;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.meudinheiro.modules.finances.entities.ExpensesEntity;
import com.example.meudinheiro.modules.finances.repositories.ExpensesRepository;
import com.example.meudinheiro.modules.user.entities.UserEntity;

public class ExpensesForUserUseCase {
    
    @Autowired
    private ExpensesRepository expensesRepository;

    public List<ExpensesEntity> getExpensesForUser(UserEntity user, LocalDateTime starDate, LocalDateTime endDate) {
        return expensesRepository.findUserAndDateBetween(user, starDate, endDate);
    }
}
