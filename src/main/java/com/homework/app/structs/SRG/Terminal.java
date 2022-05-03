package com.homework.app.structs.SRG;


import com.homework.app.exceptions.InvalidSRG;

import java.util.ArrayList;

// Represents a Terminal symbol in a SRG
public class Terminal {
    private final static ArrayList<Character> symbolsAllowed = new ArrayList<>();
    private final char symbol;

    public Terminal(char symbol) throws InvalidSRG {
        if (!symbolsAllowed.contains(symbol)){
            throw new InvalidSRG(" Terminal " + symbol + " is not listed in the grammar definition!");
        }
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public static void addSymbolsAllowed(char symbol) {
            Terminal.symbolsAllowed.add(symbol);
    }

    public static void clearSymbolsAllowed(){
        Terminal.symbolsAllowed.clear();
    }

    public static ArrayList<Character> getSymbolsAllowed(){
        return symbolsAllowed;
    }


}
