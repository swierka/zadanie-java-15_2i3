package com.moneymanager.expensemanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ExpensesController {

    @Autowired
    private AllExpenses allExpenses;

    @RequestMapping("/wydatki")
    @ResponseBody
    public String getAllExpenses() {
        List<Expense> listExpenses = allExpenses.getAllExpenses();
        String result = "";
        for (Expense allExp : listExpenses) {
            result += listExpenses.toString() + "</br>";
        }
        return result;
    }

    @GetMapping("/wydatki")
    public List<Expense> sortList(@RequestParam String kategoria) {
        List<Expense> listExpenses = allExpenses.getAllExpenses();
        List<Expense> sortedList = allExpenses.getAllExpenses();
        for (Expense allExp : listExpenses) {
            if (allExp.getCategory().toString().equals(kategoria)) {
                sortedList.add(allExp);
            }
        }
        return sortedList;
    }
/*
    @RequestMapping("/dodajWydatek")
    @ResponseBody
    public String addExpense() {
        return "dodajWydatek.html";
    }*/


    @RequestMapping("/dodajWydatek")
    public String addNewExpense(@RequestParam String wydatek, double cena, String kategoria) {
        Category kategoriaEnum = Category.valueOf(kategoria);
        Expense expense = new Expense(wydatek, cena, kategoriaEnum);
        allExpenses.addToList(expense);
        return "Dodano wydatek:" + wydatek + " "+ cena + "zl "+ "do kategorii "+kategoria;
    }
}
