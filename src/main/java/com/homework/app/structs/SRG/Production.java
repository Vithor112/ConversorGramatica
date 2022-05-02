package com.homework.app.structs.SRG;

public class Production {
    private Variable originalVar;
    private Word generatedWord;

    public void setOriginalVar(Variable originalVar) {
        this.originalVar = originalVar;
    }
    
    public Word getGeneratedWord() {
        return generatedWord;
    }

    public Variable getOriginalVar() {
        return originalVar;
    }

}
