package com.moneymanager.expensemanager.model;

public enum Category {
    FOOD ("jedzenie"),
    HOUSING ("mieszkanie"),
    UTILTIES ("media"),
    CLOTHES ("ubrania"),
    ENTERTAIMNET ("rozrywka"),
    TRANSPORT ("transport"),
    PERSONAL_CARE ("kosmetyki");

    private String inPolish;

    Category(String inPolish) {
        this.inPolish = inPolish;
    }
}
