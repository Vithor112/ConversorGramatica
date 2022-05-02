package com.homework.app.exceptions;

public class InvalidFile extends Exception {
    private final String message;
    private final String fileName;
    private final String fileType;
    public InvalidFile(String message, String fileType, String fileName){
        super(message);
        this.message = message;
        this.fileType = fileType;
        this.fileName = fileName;
    }

    @Override
    public String getMessage(){
        return "The "+fileType+" File " +fileName + " is invalid! "+ message;
    }
}


