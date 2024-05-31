package com.example.meudinheiro.modules.finances.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.meudinheiro.modules.finances.entities.CategoriesEntity;
import com.example.meudinheiro.modules.finances.entities.ExpensesEntity;
import com.example.meudinheiro.modules.finances.entities.IncomesEntity;

public interface CategoryRepository extends JpaRepository<CategoryRepository, UUID>{
    
    List<CategoriesEntity> findIncomeByCategory(IncomesEntity income);

    List<CategoriesEntity> findExpenseByCategory(ExpensesEntity expense);
}
