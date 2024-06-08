package com.example.meudinheiro.modules.user.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateTransactionDTO {
    
    private String description;
    private Double amount;
    private LocalDateTime dateTime;
    private String categoryName;
    private UUID userId;
    private String categoryType;
}
