package com.homework.app.structs.SRG;


import com.homework.app.exceptions.InvalidSRG;

import java.util.ArrayList;
import java.util.Objects;

// Represent a Variable in a SRG
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
        return this.symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Variable)
            return (((Variable) o).getSymbol() == this.symbol);
        return false;
    }

    public static void addSymbolsAllowed(char symbol) {
        Variable.symbolsAllowed.add(symbol);
    }

    public static void clearSymbolsAllowed(){
        Variable.symbolsAllowed.clear();
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol);
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
