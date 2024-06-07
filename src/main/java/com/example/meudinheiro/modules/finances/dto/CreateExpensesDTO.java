package com.example.meudinheiro.modules.finances.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateExpensesDTO {
    
    private String expensesDescription;
    private Double expensesAmount;
    private LocalDateTime expensesDateTime;
    private String categoryName;
}
