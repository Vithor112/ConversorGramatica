package com.homework.app.structs.SRG;

import java.util.ArrayList;
// Strictly regular grammar
public class SRG {
    private final Variable initial;
    private final ArrayList<Production> productions;
    private final ArrayList<Variable> variables;
    private final ArrayList<Terminal> terminals;

    public SRG(ArrayList<Production> productions, ArrayList<Variable> variables, ArrayList<Terminal> terminals, Variable initial) {
        this.initial = initial;
        this.productions = productions;
        this.variables = variables;
        this.terminals = terminals;
    }

    public ArrayList<Production> getProductions() {
        return productions;
    }

    public ArrayList<Variable> getVariables() {
        return variables;
    }

    public ArrayList<Terminal> getTerminals() {
        return terminals;
    }

    public Variable getInitial() {
        return initial;
    }

}
