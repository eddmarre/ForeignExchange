package com.example.cryptoforeignexchange;

public class CurrencySymbol {
    private String code;
    private String symbol;
    private String currencyName;

    public CurrencySymbol(String code,String symbol,String name)
    {
        this.code =code;
        this.symbol=symbol;
        this.currencyName =name;
    }

    public String getCode() {
        return code;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    @Override
    public String toString()
    {
        return "Name: "+currencyName +"\t\tcode: "+code+"\t\tsymbol: "+symbol+"\n";
    }
}
