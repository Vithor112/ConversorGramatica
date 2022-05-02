package com.homework.app.structs.SRG;


//  In a Strictly regular grammar the generated word can be empty, or a terminal, or a variable, or a terminal followed by a variable;
public class Word {
    private Terminal terminal;
    private Variable variable;

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }

    public void setVariable(Variable variable) {
        this.variable = variable;
    }

    public Terminal getTerminal() {
        return terminal;
    }
    public Variable getVariable() {
        return variable;
    }
    public String toString(){
        StringBuilder ret = new StringBuilder();
        if (terminal != null)
            ret.append(terminal.getSymbol());
        if (variable != null)
            ret.append(variable.getSymbol());
        if (terminal == null && variable == null)
            ret.append("&");  // empty symbol
        return ret.toString();
    }


}
