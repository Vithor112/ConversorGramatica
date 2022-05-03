package com.homework.app.structs.FSA;

import com.homework.app.structs.SRG.Variable;

import java.util.*;
import java.util.stream.Collectors;

// Finite-state automaton
public class FSA {
    private State initialState;
    private final String name;
    private final HashMap<Variable, State> states;
    private final HashMap<State, ArrayList<Transition>> transitions;


    public FSA(String name){
        this.name = name;
        states = new HashMap<>();
        transitions = new HashMap<>();
    }
    public String getName() {
        return name;
    }
    public HashMap<Variable, State> getStates() {
        return states;
    }

    public HashMap<State, ArrayList<Transition>> getTransitions() {
        return transitions;
    }

    public void addState(Variable var, State state) {
        this.states.put(var, state);
    }

    public void addTransition(State state, Transition transition){
        if (!transitions.containsKey(state)){
            transitions.put(state, new ArrayList<>());
        }
        this.transitions.get(state).add(transition);
    }

    public State getCorrespondentState(Variable variable){
        return states.get(variable);
    }

    public State getFinalState(){
        return states.get(null);
    }


    public State getInitialState() {
        return initialState;
    }

    public void setInitialState(State initialState) {
        this.initialState = initialState;
    }

    // TODO
//    public boolean isInfinite(){
//        LinkedList<State> actualStates = new LinkedList<>();
//        actualStates.add(this.getInitialState());
//        LinkedList<State> nextStates = new LinkedList<>();
//        while (!actualStates.isEmpty()){
//            for (Transition transition : transitions.get(actualStates.pop())){
//                State state = transition.getNextState();
//                if (actualStates.contains())
//                nextStates.push(state);
//            }
//        }
//            if (nextStates.isEmpty())
//                break;
//            actualStates = nextStates;
//
//        return actualStates.contains(this.getFinalState());
//    }

    private boolean runWord(String word){
        Stack<State> actualStates = new Stack<>();
        actualStates.push(this.getInitialState());
        for (char ch : word.toCharArray()){
            Stack<State> nextStates = new Stack<>();
            while (!actualStates.isEmpty()){
                for (Transition transition : transitions.get(actualStates.pop())){
                    State state = transition.executeTransition(ch);
                    if (state != null)
                        nextStates.push(state);
                }
            }
            if (nextStates.isEmpty())
                break;
            actualStates = nextStates;
        }
        return actualStates.contains(this.getFinalState());
    }
    public HashMap<Boolean, String> determineWords(ArrayList<String> list){
        HashMap<Boolean, String> ret = new HashMap<>();
        for (String word : list){
            Boolean result = runWord(word);
            ret.put(result, word);
        }
        return ret;
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
