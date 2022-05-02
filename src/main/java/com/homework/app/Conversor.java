package com.homework.app;

import com.homework.app.structs.FSA.Alphabet;
import com.homework.app.structs.FSA.FSA;
import com.homework.app.structs.FSA.State;
import com.homework.app.structs.FSA.Transition;
import com.homework.app.structs.SRG.Production;
import com.homework.app.structs.SRG.SRG;
import com.homework.app.structs.SRG.Variable;

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
        FSA fsa = new FSA();

        int counter = 0;
        for (Variable var : grammar.getVariables()){
            State s = new State(var, "q"+counter, false);
            fsa.addState(s);
            counter++;

            if (s.getVariableCorrespondent().equals(grammar.getInitial())){
                s.setInitialState(true);
            }
        }
        fsa.addState(new State(null, "qf", true));

        for (Production prod : grammar.getProductions()){
            State actual = fsa.getCorrespondentState(prod.getOriginalVar());
            State next = prod.getGeneratedWord().getVariable() !=  null ? fsa.getCorrespondentState(prod.getGeneratedWord().getVariable()) : fsa.getFinalState();
            Alphabet symbol = new Alphabet(prod.getGeneratedWord().getTerminal() !=  null ? prod.getGeneratedWord().getTerminal().getSymbol() : null );
            fsa.addTransition(new Transition(actual,next,symbol));
        }
        return fsa;
    }
}
