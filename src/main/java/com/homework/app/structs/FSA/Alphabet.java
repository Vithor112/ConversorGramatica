package com.homework.app.structs.FSA;

import com.homework.app.structs.SRG.Terminal;

import java.util.ArrayList;

public class Alphabet  {
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
}
