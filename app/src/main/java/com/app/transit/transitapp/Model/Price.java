package com.app.transit.transitapp.Model;

/**
 * Created by Sabrine on 08/11/2017.
 */

public class Price {

    String currency;
    double amount;

    public Price(String currency, double amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
