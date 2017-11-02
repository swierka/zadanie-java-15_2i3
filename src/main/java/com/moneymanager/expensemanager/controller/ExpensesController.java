package com.moneymanager.expensemanager.controller;

import com.moneymanager.expensemanager.db.AllExpenses;
import com.moneymanager.expensemanager.model.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
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

    @RequestMapping("/dodajWydatek")
    @ResponseBody
    public String addExpense() {
        return "dodajWydatek.html";
    }

    @GetMapping("/wydatki")
    public List<Expense> sortList(@RequestParam String kategoria) {
        List<Expense> listExpenses = allExpenses.getAllExpenses();
        List<Expense> sortedList = allExpenses.getAllExpenses();
        for (Expense allExp : listExpenses) {
            if (allExp.getCategory().equals(kategoria)) {
                sortedList.add(allExp);
            }
        }
        return sortedList;
    }
}
