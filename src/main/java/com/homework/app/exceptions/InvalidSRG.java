package com.homework.app.exceptions;

public class InvalidSRG extends Exception{
    private final String message;
    public InvalidSRG(String message){
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage(){
        return "The SRG is invalid! "+ message;
    }
}
