package com.example.meudinheiro.modules.user.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.meudinheiro.modules.user.dto.CreateTransactionDTO;
import com.example.meudinheiro.modules.user.entities.UserEntity;
import com.example.meudinheiro.modules.user.repositories.UserRepository;
import com.example.meudinheiro.modules.user.useCases.CalculateTheBalanceUseCase;
import com.example.meudinheiro.modules.user.useCases.NewTransactionUseCase;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private CalculateTheBalanceUseCase calculateTheBalanceUseCase;

    @Autowired
    private NewTransactionUseCase newTransactionUseCase;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/balance")
    public Double getBalance(@RequestParam String userEmail, @RequestParam String startDate, @RequestParam String endDate) {
        UserEntity user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("Esse email não existe"));
        LocalDateTime startDateTime = LocalDateTime.parse(startDate);
        LocalDateTime endDateTime = LocalDateTime.parse(endDate);
        
        return calculateTheBalanceUseCase.calculateBalance(user, startDateTime, endDateTime);
    }
    
    @PostMapping("/create")
    public ResponseEntity<Void> createTransaction(@RequestBody CreateTransactionDTO dto) {
        newTransactionUseCase.createTransaction(dto);
        return ResponseEntity.ok().build();
    }
}
