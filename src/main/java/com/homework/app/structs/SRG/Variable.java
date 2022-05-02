package com.homework.app.structs.SRG;


import com.homework.app.exceptions.InvalidSRG;

import java.util.ArrayList;

public class Variable {
    private final static ArrayList<Character> symbolsAllowed = new ArrayList<>();
    private final char symbol;

    public Variable(char symbol) throws InvalidSRG{
        if (!symbolsAllowed.contains(symbol)){
            throw new InvalidSRG(" Variable " + symbol + " is not listed in the grammar definition!");
        }
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Variable)
            return (((Variable) o).getSymbol() == symbol);
        return false;
    }

    public static void addSymbolsAllowed(char symbol) {
        Variable.symbolsAllowed.add(symbol);
    }

    public static void clearSymbolsAllowed(){
        Variable.symbolsAllowed.clear();
    }


    @Override
    public String toString() {
        return "Variable{" +
                "symbol='" + symbol + '\'' +
                '}';
    }

    public static ArrayList<Character> getSymbolsAllowed(){
        return symbolsAllowed;
    }

}
