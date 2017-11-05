package com.moneymanager.expensemanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    @RequestMapping("/")
    @ResponseBody
    public String dataTime (){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(Calendar.getInstance().getTime());
    }
}
