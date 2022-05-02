package com.homework.app.structs.SRG;

import java.util.ArrayList;
// Strictly regular grammar
public class SRG {
    private Variable initial;
    private final ArrayList<Production> productions;
    private final ArrayList<Variable> variables;
    private final ArrayList<Terminal> terminals;

    public SRG() {
        this.productions = new ArrayList<>();
        this.variables = new ArrayList<>();
        this.terminals = new ArrayList<>();
    }

    public void addProduction(Production prod){
        productions.add(prod);
    }

    public void addVariable(Variable variable){
        variables.add(variable);
    }

    public void addTerminal(Terminal terminal){
        terminals.add(terminal);
    }

    public void setInitial(Variable variable){
        this.initial = variable;
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
