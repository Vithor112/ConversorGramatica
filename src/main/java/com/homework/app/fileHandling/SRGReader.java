package com.homework.app.fileHandling;

import com.homework.app.exceptions.InvalidFile;
import com.homework.app.exceptions.InvalidSRG;
import com.homework.app.structs.SRG.SRG;
import com.homework.app.structs.SRG.Terminal;
import com.homework.app.structs.SRG.Variable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SRGReader {
    private final File file;
    private FileReader fileReader;
    private final InvalidFile invalidFormat;

    private SRG srg;

    public SRGReader(File file){
        this.file = file;
        this.invalidFormat = new InvalidFile("File is in an invalid format! ", "SRG", file.getName());
    }

    private SRG readFile() throws InvalidFile, InvalidSRG{
        try {
            srg = new SRG();
            Variable.clearSymbolsAllowed();
            Terminal.clearSymbolsAllowed();
            if (!file.canRead())
                throw new InvalidFile("File is not readable!", "SRG", file.getName());
            this.fileReader = new FileReader(file);
            int ch;
            // TODO readName SRG
            getName('=');
            readUntilSymbol('{');
            readVariables();
            readUntilSymbol('{');
            readTerminals();
            readUntilSymbol('<');
            String prodName = getName(',');
            String initial = getName(')');
            srg.setInitial(new Variable(initial));
            readName(prodName);



        } catch(IOException e){
            if (e instanceof  FileNotFoundException)
                throw new InvalidFile("File was not found!", "SRG", file.getName());
            throw new InvalidFile("An error occurred", "SRG", file.getName());

        }

        return null;
    }

    private void readProductions(){
        int ch;
        while (ch )
    }

    private void readName(String name) throws IOException, InvalidFile{
        int ch;
        int counter = 0;
        while (true){
            ch = fileReader.read();
            if (ch == -1)
                throw invalidFormat;

            if (name.charAt(counter) == (char)ch){
                counter++;
                if (counter == name.length())
                    break;
            }
            else {
                counter = 0;
            }
        }
    }

    private void readVariables() throws  IOException, InvalidFile, InvalidSRG {
        int ch;
        StringBuilder stringBuilder= new StringBuilder();
        while ( true ){
            ch = fileReader.read();
            if (ch == -1){
                throw invalidFormat;
            }
            if ((char)ch == ',' || (char)ch == '}') {
                Variable.addSymbolsAllowed(stringBuilder.toString());
                srg.addVariable(new Variable(stringBuilder.toString()));
                stringBuilder.delete(0, stringBuilder.length());
                if ((char)ch == '}')
                    break;
                continue;
            }
            if ((char) ch != ' ')
                stringBuilder.append((char)ch);
            }

        }

    private void readTerminals() throws  IOException, InvalidFile, InvalidSRG {
        int ch;
        StringBuilder stringBuilder= new StringBuilder();
        while ( true ){
            ch = fileReader.read();
            if (ch == -1){
                throw invalidFormat;
            }
            if ((char)ch == ',' || (char)ch == '}') {
                Terminal.addSymbolsAllowed(stringBuilder.toString());
                srg.addTerminal(new Terminal(stringBuilder.toString()));
                stringBuilder.delete(0, stringBuilder.length());
                if ((char)ch == '}')
                    break;
                continue;
            }
            if ((char) ch != ' ')
                stringBuilder.append((char)ch);
        }

    }

    private String getName(char terminator) throws  IOException, InvalidFile{
        StringBuilder  stringBuilder = new StringBuilder();
        int ch;
        while ((char)(ch=fileReader.read())!=terminator){
            if (ch == -1){
                throw invalidFormat;
            }
            stringBuilder.append((char) ch);
        }
        return stringBuilder.toString();
    }

    private void readUntilSymbol(char symbol) throws InvalidFile, IOException{
        int ch;
        while ((char)(ch=fileReader.read())!=symbol) {
            if (ch == -1){
                throw invalidFormat;
            }
        }
    }

}
