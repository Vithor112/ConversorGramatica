package com.homework.app.structs.FSA;

public class State {
    private final Boolean finalState;
    private final String label;

    public State(Boolean finalState, String label) {
        this.finalState = finalState;
        this.label = label;
    }

    public Boolean getFinalState() {
        return finalState;
    }

    public String getLabel() {
        return label;
    }


}
