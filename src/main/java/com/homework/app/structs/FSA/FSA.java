package com.homework.app.structs.FSA;

import com.homework.app.structs.SRG.Variable;

import java.util.*;
import java.util.stream.Collectors;

// Represents a Finite-state automaton
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

    /*
        Searches for cycles in the graph, using a horizontal deep search
     */
    public boolean isInfinite(){
        boolean isInfinite = false;
        // The HashMap will store a list the paths using the last state in the path as the key
        HashMap<State, ArrayList<LinkedList<State>>> paths = new HashMap<>();
        // Setting first path
        LinkedList<State> pathInitial = new LinkedList<>();
        pathInitial.add(this.getInitialState());
        ArrayList<LinkedList<State>> array = new ArrayList<>();
        array.add(pathInitial);
        paths.put(this.getInitialState(), array);
        while (!paths.isEmpty() && !isInfinite){
            // This new hashmap will store the paths from the next level
            HashMap<State, ArrayList<LinkedList<State>>> NewPaths = new HashMap<>();
            // Apply this to all states that have paths
            for (State state : paths.keySet()) {
                if (transitions.get(state) !=  null)
                    // Get all the transition from the actual state
                    for (Transition transition : transitions.get(state)) {
                        // If it's a transition that leads to no state, then skip
                        if (transition.getNextState() == null)
                            continue;
                        if (!NewPaths.containsKey(transition.getNextState()))
                            NewPaths.put(transition.getNextState(), new ArrayList<>());
                        // Apply this for all the paths that the state is the last one
                        for (LinkedList<State> oldPath : paths.get(state)) {
                            // If any of the paths contains the nextState, then it's a cycle, so the FSA recognizes an infinite language
                            if (oldPath.contains(transition.getNextState()))
                                isInfinite = true;
                            // Create a new path, using the actual path as base
                            LinkedList<State> path = new LinkedList<>(oldPath);
                            // Add the nextState as the last state of the new path
                            path.add(transition.getNextState());
                            // Add the new path in the new HashMap
                            NewPaths.get(transition.getNextState()).add(path);
                        }
                    }
            }
            // Change HashMap
            paths = NewPaths;
        }
        return isInfinite;
    }

    // Go to all the possible paths, and try to find one that ends in a final state
    private boolean runWord(String word){
        Stack<State> actualStates = new Stack<>();
        // Setting the stack putting the initial state in it
        actualStates.push(this.getInitialState());
        // For all the symbols in the word
        for (char ch : word.toCharArray()){
            // new Stack that will store the next states
            Stack<State> nextStates = new Stack<>();
            // For all the states in the stack
            while (!actualStates.isEmpty()){
                State state = actualStates.pop();
                if (transitions.get(state) != null)
                    // For all the transitions of the state
                    for (Transition transition : transitions.get(state)){
                        // Try to use the transition for the actual symbol, if it's possible then state will be the nextState
                        State stateNext = transition.executeTransition(ch);
                        // If the transition was successful then store the NextState in the stack
                        if (stateNext != null)
                            nextStates.push(stateNext);
                    }
            }
            // If there is no more possible paths, then finalize the loop ( actualState will be empty, because all the states were popped out )
            if (nextStates.isEmpty())
                break;
            actualStates = nextStates;
        }
        // If the stack contains the finalState when the last symbol was consumed, then the word exists in the language.
        return actualStates.contains(this.getFinalState());
    }

    // Apply to all the words in the list and put in a HashMap where the values stored with the key value are in the language and vice versa
    public HashMap<Boolean, ArrayList<String>> determineWords(ArrayList<String> list){
        HashMap<Boolean, ArrayList<String>> ret = new HashMap<>();
        ret.put(true, new ArrayList<>());
        ret.put(false, new ArrayList<>());
        for (String word : list){
            Boolean result = runWord(word);
            ret.get(result).add(word);
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
