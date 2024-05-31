package com.example.meudinheiro.modules.finances.entities;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "categories")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoriesEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "category_name")
    private String name;

    @OneToMany(mappedBy = "categoriesEntity")
    private List<ExpensesEntity> expensesEntity;

    @OneToMany(mappedBy = "categoriesEntity")
    private List<IncomesEntity> incomesEntity;

}
