package com.homework.app.structs.FSA;

public class State {
    private final String label;

    public State(Boolean finalState, String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }


}
