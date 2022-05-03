package com.homework.app.structs.FSA;

import com.homework.app.structs.SRG.Terminal;

import java.util.ArrayList;

// Represents the Alphabet and a terminal symbol in a FSA
public class Alphabet  {
    private static ArrayList<Character> SymbolsAllowed = null;
    private final Character symbol;

    public Character getSymbol() {
        return symbol;
    }

    public Alphabet(Character symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "Alphabet{" +
                "symbol='" + symbol + '\'' +
                '}';
    }

    public static ArrayList<Character> getSymbolsAllowed() {
        return SymbolsAllowed;
    }

    public static void setSymbolsAllowed(ArrayList<Character> symbolsAllowed) {
        SymbolsAllowed = symbolsAllowed;
    }
}
