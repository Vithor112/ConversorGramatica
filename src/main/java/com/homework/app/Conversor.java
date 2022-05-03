package com.homework.app;

import com.homework.app.structs.FSA.Alphabet;
import com.homework.app.structs.FSA.FSA;
import com.homework.app.structs.FSA.State;
import com.homework.app.structs.FSA.Transition;
import com.homework.app.structs.SRG.Production;
import com.homework.app.structs.SRG.SRG;
import com.homework.app.structs.SRG.Terminal;
import com.homework.app.structs.SRG.Variable;


// Converts a SRG to a FSA
public class Conversor {
    private final SRG grammar;
    private final FSA fsa;

    public Conversor(SRG grammar) {
        this.grammar = grammar;
        this.fsa = convertGrammarToAutomaton();
    }

    public SRG getGrammar() {
        return grammar;
    }

    public FSA getFsa(){
        return fsa;
    }

    private FSA convertGrammarToAutomaton(){
        FSA fsa = new FSA(grammar.getName());
        Alphabet.setSymbolsAllowed(Terminal.getSymbolsAllowed());
        int counter = 0;
        // Creates a state for each variable
        for (Variable var : grammar.getVariables()){
            State s = new State( "q"+counter, false);
            // Stores it in a Hashmap where the key for each state is the variable that it represents
            fsa.addState(var, s);
            counter++;

            if (var.equals(grammar.getInitial())){
                s.setInitialState(true);
                fsa.setInitialState(s);
            }
        }
        // Create an additional state that represents the final state, as it doesn't represent any variable its key is null
        fsa.addState(null, new State("qf", true));

        for (Production prod : grammar.getProductions()){
            // Get the state that represents the leftSide variable
            State actual = fsa.getCorrespondentState(prod.getOriginalVar());
            // If the  variable of the generated word is null, it means is a terminal production, so it leads to the finalState
            State next = prod.getGeneratedWord().getVariable() !=  null ? fsa.getCorrespondentState(prod.getGeneratedWord().getVariable()) : fsa.getFinalState();
            // If the terminal of the generated word is null, it means that the terminal is the empty word/symbol
            Alphabet symbol = new Alphabet(prod.getGeneratedWord().getTerminal() !=  null ? prod.getGeneratedWord().getTerminal().getSymbol() : null );
            fsa.addTransition(actual, new Transition(actual,next,symbol));
        }
        return fsa;
    }
}
