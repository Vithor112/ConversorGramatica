package com.homework.app.structs.FSA;

import java.lang.reflect.Array;
import java.util.ArrayList;

// Finite-state automaton
public class FSA {
    private final State initial;
    private final ArrayList<State> finalStates;
    private final ArrayList<Transition> transitions;


    public FSA(State initial, ArrayList<State> finalStates, ArrayList<Transition> transitions) {
        this.initial = initial;
        this.finalStates = finalStates;
        this.transitions = transitions;
    }

    public State getInitial() {
        return initial;
    }

    public ArrayList<State> getFinalStates() {
        return finalStates;
    }

    public ArrayList<Transition> getTransitions() {
        return transitions;
    }
}
