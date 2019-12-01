package com.example.android3.ui.fragmets.currency;

import java.util.Date;

public class Root

{
    private boolean success;

    private int timestamp;

    private String base;

    private Date date;

    private Rates rates;

    public void setSuccess(boolean success){
        this.success = success;
    }
    public boolean getSuccess(){
        return this.success;
    }
    public void setTimestamp(int timestamp){
        this.timestamp = timestamp;
    }
    public int getTimestamp(){
        return this.timestamp;
    }
    public void setBase(String base){
        this.base = base;
    }
    public String getBase(){
        return this.base;
    }
    public void setDate(Date date){
        this.date = date;
    }
    public Date getDate(){
        return this.date;
    }
    public void setRates(Rates rates){
        this.rates = rates;
    }
    public Rates getRates(){
        return this.rates;
    }
}