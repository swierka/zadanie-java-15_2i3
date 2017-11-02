package com.moneymanager.expensemanager.io;

import com.moneymanager.expensemanager.model.Expense;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class NewExpense extends HttpServlet {
    private List<Expense> expenses;

    @Autowired
     public NewExpense(List<Expense> expenses) {
        this.expenses = expenses;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        String name = request.getParameter("nazwa");
        String priceStr = request.getParameter("cena");
        double price = Double.parseDouble(priceStr);
        String category = request.getParameter("kategoria");


        if (name != null) {
            Expense expense = new Expense(name, price, category);
            expenses.add(expense);
        }
    }
}
