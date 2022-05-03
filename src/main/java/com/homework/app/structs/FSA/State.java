package com.homework.app.structs.FSA;


import java.util.Objects;


// Represent a state in a FSA
public class State {
    private final String label;
    private final boolean IsFinalState;
    private boolean isInitialState = false;

    public State(String label, boolean IsFinalState) {
        this.label = label;
        this.IsFinalState = IsFinalState;
    }

    public String getLabel() {
        return label;
    }

    public boolean getIsFinalState(){
        return IsFinalState;
    }

    public boolean isFinalState() {
        return IsFinalState;
    }

    public boolean isInitialState() {
        return isInitialState;
    }

    public void setInitialState(boolean initialState) {
        isInitialState = initialState;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof State)
            return ((State) o).getLabel().equals(this.label);
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }

    @Override
    public String toString() {
        return "State{" +
                "label='" + label + '\'' +
                ", IsFinalState=" + IsFinalState +
                ", isInitialState=" + isInitialState +
                '}';
    }
}
