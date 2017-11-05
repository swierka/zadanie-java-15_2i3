package com.moneymanager.expensemanager.db;

import com.moneymanager.expensemanager.model.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AllExpenses {
    private List<Expense> expenses = new ArrayList<>();

    @Autowired
    public AllExpenses() {
    }

    public void addToList (Expense expense){
        expenses.add(expense);
    }

    public List<Expense> getAllExpenses() {
        return expenses;
    }
}
