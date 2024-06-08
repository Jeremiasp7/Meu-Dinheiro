package com.example.meudinheiro.modules.user.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.meudinheiro.modules.finances.entities.ExpensesEntity;
import com.example.meudinheiro.modules.finances.entities.IncomesEntity;
import com.example.meudinheiro.modules.finances.repositories.ExpensesRepository;
import com.example.meudinheiro.modules.finances.repositories.IncomesRepository;
import com.example.meudinheiro.modules.user.dto.CreateTransactionDTO;
import com.example.meudinheiro.modules.user.entities.UserEntity;
import com.example.meudinheiro.modules.user.repositories.UserRepository;

@Service
public class NewTransactionUseCase {
    
    @Autowired
    private ExpensesRepository expensesRepository;

    @Autowired
    private IncomesRepository incomesRepository;

    @Autowired
    private UserRepository userRepository;

    public void createTransaction(CreateTransactionDTO dto) {
        UserEntity user = userRepository.findById(dto.getUserId()).orElseThrow(() -> new RuntimeException("O usuário não foi encontrado"));

        if("ganho".equalsIgnoreCase(dto.getCategoryType())) {
            ExpensesEntity expense = ExpensesEntity.builder()
                .description(dto.getDescription())
                .amount(dto.getAmount())
                .date(dto.getDateTime())
                .category_name(dto.getCategoryName())
                .user(user)
                .build();
            expensesRepository.save(expense);
        } else if ("gasto".equalsIgnoreCase(dto.getCategoryType())) {
            IncomesEntity income = IncomesEntity.builder()
                .description(dto.getDescription())
                .amount(dto.getAmount())
                .date(dto.getDateTime())
                .category_name(dto.getCategoryName())
                .user(user)
                .build();   
            incomesRepository.save(income);
        } else {
            throw new IllegalArgumentException("Transação inválida: " + dto.getCategoryType());
        }
    }

}
