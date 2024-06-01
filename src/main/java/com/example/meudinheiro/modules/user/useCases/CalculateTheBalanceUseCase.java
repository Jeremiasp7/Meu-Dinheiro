package com.example.meudinheiro.modules.user.useCases;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.meudinheiro.modules.finances.entities.ExpensesEntity;
import com.example.meudinheiro.modules.finances.entities.IncomesEntity;
import com.example.meudinheiro.modules.finances.useCases.ExpensesForUserUseCase;
import com.example.meudinheiro.modules.finances.useCases.IncomesForUserUseCase;
import com.example.meudinheiro.modules.user.entities.UserEntity;

public class CalculateTheBalanceUseCase {

    @Autowired
    private ExpensesForUserUseCase expensesForUserUseCase;

    @Autowired
    private IncomesForUserUseCase incomesForUserUseCase;

    public Double calculatebalance(UserEntity user, LocalDateTime starDateTime, LocalDateTime endDateTime) {
        List<ExpensesEntity> expenses = expensesForUserUseCase.getExpensesForUser(user, starDateTime, endDateTime);
        List<IncomesEntity> incomes = incomesForUserUseCase.getIncomesForUser(user, starDateTime, endDateTime);

        Double totalExpenses = expenses.stream().mapToDouble(ExpensesEntity::getAmount).sum();
        Double totalIncomes = incomes.stream().mapToDouble(IncomesEntity::getAmount).sum();

        return totalIncomes - totalExpenses;
    }
}
