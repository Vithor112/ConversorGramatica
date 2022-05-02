package com.homework.app.structs;

public class Production {
    private Variable originalVar;
    private Word generatedWord;

    public Word getGeneratedWord() {
        return generatedWord;
    }

    public void setGeneratedWord(Word generatedWord) {
        this.generatedWord = generatedWord;
    }

    public Variable getOriginalVar() {
        return originalVar;
    }

    public void setOriginalVar(Variable originalVar) {
        this.originalVar = originalVar;
    }

}
