package com.homework.app.structs.SRG;

// Represents a production in a SRG
public class Production {
    private Variable originalVar;
    private final Word generatedWord;

    public void setOriginalVar(Variable originalVar) {
        this.originalVar = originalVar;
    }

    public Production(){
        this.generatedWord = new Word();
    }
    
    public Word getGeneratedWord() {
        return generatedWord;
    }

    public Variable getOriginalVar() {
        return originalVar;
    }

}
