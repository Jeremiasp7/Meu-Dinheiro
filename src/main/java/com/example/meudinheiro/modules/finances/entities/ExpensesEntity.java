package com.example.meudinheiro.modules.finances.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import com.example.meudinheiro.modules.user.entities.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "expenses")
@Builder
public class ExpensesEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "expenses_description")
    private String description;

    @Column(name = "expenses_amount")
    private Double amount;

    @CreationTimestamp
    private LocalDateTime date;

    @Column(name = "user_id")
    private UUID user_id;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private UserEntity user;

    @Column(name = "category_name")
    private String category_name;

    @ManyToOne
    @JoinColumn(name = "category_name", insertable = false, updatable = false)
    private CategoriesEntity categoriesEntity;
}
