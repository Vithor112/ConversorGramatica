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

    @Override
    public boolean equals(Object o) {
        if (o instanceof Variable)
            return ((Variable) o).getSymbol().equals(symbol);
        return false;
    }

    public static void setSymbolsAllowed(ArrayList<String> symbolsAllowed) {
        Variable.symbolsAllowed = symbolsAllowed;
    }


    @Override
    public String toString() {
        return "Variable{" +
                "symbol='" + symbol + '\'' +
                '}';
    }
}
