package com.homework.app.fileHandling;

import com.homework.app.exceptions.InvalidFile;
import com.homework.app.exceptions.InvalidSRG;
import com.homework.app.structs.SRG.Production;
import com.homework.app.structs.SRG.SRG;
import com.homework.app.structs.SRG.Terminal;
import com.homework.app.structs.SRG.Variable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class SRGReader {
    private final File file;
    private FileReader fileReader;
    private final InvalidFile invalidFormat;

    private SRG srg;

    public SRGReader(File file) throws InvalidSRG, InvalidFile{
        this.file = file;
        this.invalidFormat = new InvalidFile("File is in an invalid format! ", "SRG", file.getName());
        readFile();
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
            srg.setName(getName('='));
            readUntilSymbol('{');
            readVariables();
            readUntilSymbol('{');
            readTerminals();
            readUntilSymbol(',');
            String prodName = getName(',');
            String initial = getName(')');
            srg.setInitial(new Variable(initial.charAt(0)));
            readName(prodName);
            readProductions();
            return srg;
        } catch(IOException e){
            if (e instanceof  FileNotFoundException)
                throw new InvalidFile("File was not found!", "SRG", file.getName());
            throw new InvalidFile("An error occurred", "SRG", file.getName());

        }
    }

    private void readProductions() throws IOException, InvalidSRG, InvalidFile {
        int ch;
        char variableLeftSide;
        ArrayList<Character> separators = new ArrayList<Character>( Arrays.asList('-','>') );
        while ((ch = fileReader.read()) != -1){
            Production prod = new Production();
            while(ch <= 32  && ch != -1)
                ch = fileReader.read();
            if (ch == -1)
                break;
            prod.setOriginalVar(new Variable((char) ch));
            ch = fileReader.read();
            int counter = 0;
            while(((ch <= 32  && (char) ch != '\n' && (char) ch != '\r') || separators.contains((char)ch) && ch != -1)){
                if (separators.contains((char)ch))
                    counter++;
                ch = fileReader.read();
            }
            if (counter != 2)
                throw invalidFormat;
            if (ch > 32) {
                prod.getGeneratedWord().setTerminal(new Terminal((char) ch));
                ch = fileReader.read();
            }
            if (ch > 32)
                prod.getGeneratedWord().setVariable(new Variable((char)ch));
            srg.addProduction(prod);

        }
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
        while ((char) (ch = fileReader.read()) != '}') {
            if (ch == -1) {
                throw invalidFormat;
            }
            if ((char) ch == ',')
                continue;
            if ((char) ch != ' ') {
                Variable.addSymbolsAllowed((char) ch);
                srg.addVariable(new Variable((char) ch));
            }


        }
    }

    private void readTerminals() throws  IOException, InvalidFile, InvalidSRG {
        int ch;
        while ((char) (ch = fileReader.read()) != '}') {
            if (ch == -1) {
                throw invalidFormat;
            }
            if ((char) ch == ',')
                continue;
            if ((char) ch != ' ') {
                Terminal.addSymbolsAllowed((char)ch);
                srg.addTerminal(new Terminal((char) ch));
            }


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

    public SRG getSrg(){
        return srg;
    }

}
