package com.homework.app.structs.SRG;

public class Production {
    private final Variable originalVar;
    private final Word generatedWord;

    public Production(Variable originalVar, Word generatedWord) {
        this.originalVar = originalVar;
        this.generatedWord = generatedWord;
    }

    public Word getGeneratedWord() {
        return generatedWord;
    }

    public Variable getOriginalVar() {
        return originalVar;
    }

}
