package com.moneymanager.expensemanager.db;

import com.moneymanager.expensemanager.model.Expense;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ExpenseRepository {

    public List<Expense> expenses;

    public ExpenseRepository (){
        expenses = new ArrayList<>();

    }

    public List<Expense> getAll(){
        return  expenses;
    }
}
