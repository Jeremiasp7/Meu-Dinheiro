package com.example.meudinheiro.modules.finances.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import com.example.meudinheiro.modules.user.entities.UserEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "incomes")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IncomesEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "incomes_description")
    private String description;

    @Column(name = "incomes_amount")
    private Double amount;

    @CreationTimestamp
    private LocalDateTime date;

    @Column(name = "category")
    private String category;

    @Column(name = "user_id")
    private UUID user_id;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private UserEntity user;

}
