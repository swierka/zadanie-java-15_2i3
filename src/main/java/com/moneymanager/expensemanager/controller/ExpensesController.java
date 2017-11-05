package com.moneymanager.expensemanager.controller;

import com.moneymanager.expensemanager.db.AllExpenses;
import com.moneymanager.expensemanager.model.Category;
import com.moneymanager.expensemanager.model.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class ExpensesController {

    @Autowired
    private AllExpenses allExpenses;

    @GetMapping("/wydatki")
    @ResponseBody
    public String getList(@RequestParam(required = false) String kategoria)
    {
        String result = "";
        double cena = 0;
        List<Expense> listExpenses = allExpenses.getAllExpenses();
        List<Expense> filteredList = new ArrayList<>();

        if (kategoria == null) {
            for (Expense allExp : listExpenses) {
                /*result += listExpenses.toString() + "<br/>";*/
                cena +=allExp.getPrice();
            }
            return listExpenses.toString()+ "<br/>" +"Calkowita kwota "+ cena;
        } else {
            for (Expense allExp : listExpenses) {
                if (allExp.getCategory().equals(Category.valueOf(kategoria))) {
                    filteredList.add(allExp);
                    cena +=allExp.getPrice();
                }
            }
            return filteredList.toString() + "<br/>" + "Calkowita kwota "+cena;
        }
    }

    @PostMapping("/add")
    @ResponseBody
    public String addNewExpense(@RequestParam String nazwa, double cena, String kategoria) {
        Category kategoriaEnum = Category.valueOf(kategoria);
        Expense expense = new Expense(nazwa, cena, kategoriaEnum);
        allExpenses.addToList(expense);
        return "Dodano wydatek: " + nazwa + " "+ cena + "zl";
    }
}

/*
 for(Expenses expense:expenses)
   if(kategoria==null || expense.getCategory().equals(kategoria)){
   result+=expense.toString()+<br/>;
   cena+=expense.getPrice();
*/


