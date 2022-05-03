package com.homework.app;

import com.homework.app.structs.FSA.Alphabet;
import com.homework.app.structs.FSA.FSA;
import com.homework.app.structs.FSA.State;
import com.homework.app.structs.FSA.Transition;
import com.homework.app.structs.SRG.Production;
import com.homework.app.structs.SRG.SRG;
import com.homework.app.structs.SRG.Terminal;
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
        FSA fsa = new FSA(grammar.getName());
        Alphabet.setSymbolsAllowed(Terminal.getSymbolsAllowed());
        int counter = 0;
        for (Variable var : grammar.getVariables()){
            State s = new State( "q"+counter, false);
            fsa.addState(var, s);
            counter++;

            if (var.equals(grammar.getInitial())){
                s.setInitialState(true);
                fsa.setInitialState(s);
            }
        }
        fsa.addState(null, new State("qf", true));

        for (Production prod : grammar.getProductions()){
            State actual = fsa.getCorrespondentState(prod.getOriginalVar());
            State next = prod.getGeneratedWord().getVariable() !=  null ? fsa.getCorrespondentState(prod.getGeneratedWord().getVariable()) : fsa.getFinalState();
            Alphabet symbol = new Alphabet(prod.getGeneratedWord().getTerminal() !=  null ? prod.getGeneratedWord().getTerminal().getSymbol() : null );
            fsa.addTransition(actual, new Transition(actual,next,symbol));
        }
        return fsa;
    }
}
