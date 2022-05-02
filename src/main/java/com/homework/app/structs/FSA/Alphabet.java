package com.homework.app.structs.FSA;

import com.homework.app.structs.SRG.Terminal;

import java.util.ArrayList;

public class Alphabet  {
    private static ArrayList<String> symbolsAllowed;
    private final String symbol;

    public String getSymbol() {
        return symbol;
    }

    public Alphabet(String symbol) {
        this.symbol = symbol;
    }

    public static void setSymbolsAllowed(ArrayList<String> symbolsAllowed) {
        Alphabet.symbolsAllowed = symbolsAllowed;
    }

    @Override
    public String toString() {
        return "Alphabet{" +
                "symbol='" + symbol + '\'' +
                '}';
    }
}
