package com.example.meudinheiro.modules.finances.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.meudinheiro.modules.finances.useCases.ExpensesForUserUseCase;
import com.example.meudinheiro.modules.finances.useCases.IncomesForUserUseCase;
import com.example.meudinheiro.modules.user.entities.UserEntity;
import com.example.meudinheiro.modules.finances.dto.CreateExpensesDTO;
import com.example.meudinheiro.modules.finances.dto.CreateIncomeDTO;
import com.example.meudinheiro.modules.user.repositories.UserRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/finance")
public class FinancesController {
    @Autowired
    private IncomesForUserUseCase incomesForUserUseCase;

    @Autowired
    private ExpensesForUserUseCase expensesForUserUseCase;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/expenses")
    public List<CreateExpensesDTO> getExpenses(@RequestParam String userEmail, @RequestParam String startDate, @RequestParam String endDate) {
        UserEntity user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        LocalDateTime startDateTime = LocalDateTime.parse(startDate);
        LocalDateTime endDateTime = LocalDateTime.parse(endDate);
        
        return expensesForUserUseCase.getExpensesForUser(user, startDateTime, endDateTime); 
    }    

    @GetMapping("/incomes")
    public List<CreateIncomeDTO> getIncomes(@RequestParam String userEmail, @RequestParam String startDate, @RequestParam String endDate) {
        UserEntity user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        LocalDateTime starDateTime = LocalDateTime.parse(startDate);
        LocalDateTime endDateTime = LocalDateTime.parse(endDate);
        
        return incomesForUserUseCase.getIncomesForUser(user, starDateTime, endDateTime);
    }    
}
