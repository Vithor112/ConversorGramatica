package com.homework.app.structs.FSA;

import com.homework.app.structs.SRG.Variable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

// Finite-state automaton
public class FSA {

    private final HashMap<Variable, State> states;
    private final HashMap<State, Transition> transitions;


    public FSA(){
        states = new HashMap<>();
        transitions = new HashMap<>();
    }
    public HashMap<Variable, State> getStates() {
        return states;
    }

    public HashMap<State, Transition> getTransitions() {
        return transitions;
    }

    public void addState(Variable var, State state) {
        this.states.put(var, state);
    }

    public void addTransition(State state, Transition transition){
        this.transitions.put(state, transition);
    }

    public State getCorrespondentState(Variable variable){
        return states.get(variable);
    }

    public State getFinalState(){
        return states.get(null);
    }
    @Override
    public String toString() {
        return "FSA{" +
                "states=" + states.values().stream().map(Object::toString)
                .collect(Collectors.joining(", ")) +
                ", transitions=" + transitions.values().stream().map(Object::toString)
                .collect(Collectors.joining(", ")) +
                '}';
    }
}
