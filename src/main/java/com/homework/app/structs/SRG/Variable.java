package com.homework.app.structs.SRG;


import com.homework.app.exceptions.InvalidSRG;

import java.util.ArrayList;

public class Variable {
    private static ArrayList<String> symbolsAllowed;
    private final String symbol;

    public Variable(String symbol) throws InvalidSRG{
        if (!symbolsAllowed.contains(symbol)){
            throw new InvalidSRG(" Variable " + symbol + " is not listed in the grammar definition!");
        }
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }


    public static void setSymbolsAllowed(ArrayList<String> symbolsAllowed) {
        Variable.symbolsAllowed = symbolsAllowed;
    }


}
