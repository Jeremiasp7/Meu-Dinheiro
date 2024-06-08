package com.example.meudinheiro.modules.user.useCases;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.meudinheiro.modules.finances.dto.CreateExpensesDTO;
import com.example.meudinheiro.modules.finances.dto.CreateIncomeDTO;
import com.example.meudinheiro.modules.finances.useCases.ExpensesForUserUseCase;
import com.example.meudinheiro.modules.finances.useCases.IncomesForUserUseCase;
import com.example.meudinheiro.modules.user.entities.UserEntity;

@Service
public class CalculateTheBalanceUseCase {

    @Autowired
    private ExpensesForUserUseCase expensesForUserUseCase;

    @Autowired
    private IncomesForUserUseCase incomesForUserUseCase;

    public Double calculateBalance(UserEntity user, LocalDateTime starDateTime, LocalDateTime endDateTime) {
        List<CreateExpensesDTO> expenses = expensesForUserUseCase.getExpensesForUser(user, starDateTime, endDateTime);
        List<CreateIncomeDTO> incomes = incomesForUserUseCase.getIncomesForUser(user, starDateTime, endDateTime);

        Double totalExpenses = expenses.stream().mapToDouble(CreateExpensesDTO::getExpensesAmount).sum();
        Double totalIncomes = incomes.stream().mapToDouble(CreateIncomeDTO::getIncomesAmount).sum();

        return totalIncomes - totalExpenses;
    }
}
