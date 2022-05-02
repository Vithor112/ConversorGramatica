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

    public State getActualState() {
        return actualState;
    }

    public State getNextState() {
        return nextState;
    }

    public Alphabet getSymbol() {
        return symbol;
    }


}
