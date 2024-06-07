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
public class CreateIncomeDTO {
    
    private String incomesDescription;
    private Double incomesAmount;
    private LocalDateTime incomesDateTime;
    private String categoryName;
}
