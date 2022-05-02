package com.homework.app.structs.SRG;

import java.util.ArrayList;
// Strictly regular grammar
public class SRG {
    private Variable initial;
    private ArrayList<Production> productions;
    private ArrayList<Variable> variables;
    private ArrayList<Terminal> terminals;

    public SRG(ArrayList<Production> productions, ArrayList<Variable> variables, ArrayList<Terminal> terminals, Variable initial) {
        this.initial = initial;
        this.productions = productions;
        this.variables = variables;
        this.terminals = terminals;
    }

    public ArrayList<Production> getProductions() {
        return productions;
    }

    public void setProductions(ArrayList<Production> productions) {
        this.productions = productions;
    }

    public ArrayList<Variable> getVariables() {
        return variables;
    }

    public void setVariables(ArrayList<Variable> variables) {
        this.variables = variables;
    }

    public ArrayList<Terminal> getTerminals() {
        return terminals;
    }

    public void setTerminals(ArrayList<Terminal> terminals) {
        this.terminals = terminals;
    }

    public Variable getInitial() {
        return initial;
    }

    public void setInitial(Variable initial) {
        this.initial = initial;
    }


}
