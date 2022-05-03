package com.homework.app.structs.FSA;

public class Transition {
    private final State actualState;
    private final State nextState;
    private final Alphabet symbol;

    public Transition(State actualState, State nextState, Alphabet symbol) {
        this.actualState = actualState;
        this.nextState = nextState;
        this.symbol = symbol;
    }

    public State executeTransition(Character ch){
        if (symbol ==  null && ch == null)
            return nextState;
        if (symbol == null)
            return null;
        if (symbol.getSymbol() == ch)
            return nextState;
        return null;
    }

    public State getActualState() {
        return actualState;
    }

    public State getNextState() {
        return nextState;
    }

    public Alphabet getSymbol() {
        return symbol;
    }


    @Override
    public String toString() {
        return "Transition{" +
                "actualState=" + actualState +
                ", nextState=" + nextState +
                ", symbol=" + symbol +
                '}';
    }
}
