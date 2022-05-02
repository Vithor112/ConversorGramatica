package com.homework.app.structs.FSA;

import com.homework.app.structs.SRG.Variable;

import java.util.ArrayList;
import java.util.stream.Collectors;

// Finite-state automaton
public class FSA {
    private final ArrayList<State> states;
    private final ArrayList<Transition> transitions;


    public FSA(){
        states = new ArrayList<>();
        transitions = new ArrayList<>();
    }
    public ArrayList<State> getStates() {
        return states;
    }

    public ArrayList<Transition> getTransitions() {
        return transitions;
    }

    public void addState(State state) {
        this.states.add(state);
    }

    public void addTransition(Transition transition){
        this.transitions.add(transition);
    }

    public State getCorrespondentState(Variable var){
        for (State state : states){
            if (state.getVariableCorrespondent().equals(var))
                return state;
        }
        return null;
    }

    public State getFinalState(){
        for (State state : states){
            if (state.isFinalState())
                return state;
        }
        return null;
    }

    @Override
    public String toString() {
        return "FSA{" +
                "states=" + states.stream().map(Object::toString)
                .collect(Collectors.joining(", ")) +
                ", transitions=" + transitions.stream().map(Object::toString)
                .collect(Collectors.joining(", ")) +
                '}';
    }
}
