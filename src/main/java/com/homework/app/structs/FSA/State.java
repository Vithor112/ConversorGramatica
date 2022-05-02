package com.homework.app.structs.FSA;

import com.homework.app.structs.SRG.Variable;

public class State {
    private final String label;

    private final Variable variableCorrespondent;

    private final boolean IsFinalState;
    private boolean isInitialState = false;

    public State(Variable variableCorrespondent, String label, boolean IsFinalState) {
        this.label = label;
        this.variableCorrespondent = variableCorrespondent;
        this.IsFinalState = IsFinalState;
    }

    public Variable getVariableCorrespondent(){
        return variableCorrespondent;
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
    public String toString() {
        return "State{" +
                "label='" + label + '\'' +
                ", variableCorrespondent=" + variableCorrespondent +
                ", IsFinalState=" + IsFinalState +
                ", isInitialState=" + isInitialState +
                '}';
    }
}
