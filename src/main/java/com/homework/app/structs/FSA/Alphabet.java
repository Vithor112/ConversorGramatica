package com.homework.app.structs.FSA;

import com.homework.app.structs.SRG.Terminal;

import java.util.ArrayList;

public class Alphabet  {
    private final char symbol;

    public char getSymbol() {
        return symbol;
    }

    public Alphabet(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "Alphabet{" +
                "symbol='" + symbol + '\'' +
                '}';
    }
}
