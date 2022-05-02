package com.homework.app;

import com.homework.app.exceptions.InvalidSRG;
import com.homework.app.structs.SRG.*;

import javax.swing.*;
import java.util.ArrayList;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class App 
{
    public static void main( String[] args )
    {
        JFrame main = new JFrame("App");
        main.setContentPane(new MainGUI().panel1);
        main.setSize(500,700);
        main.setVisible(true);
        main.setDefaultCloseOperation(EXIT_ON_CLOSE);

// TEST CONVERSION
//        try {
//            ArrayList<Production> prod = new ArrayList<>();
//            ArrayList<Variable> var = new ArrayList<>();
//            ArrayList<Terminal> ter = new ArrayList<>();
//            ArrayList<String> s = new ArrayList<String>();
//            s.add("a");
//            s.add("b");
//            Terminal.setSymbolsAllowed(s);
//            ArrayList<String> x = new ArrayList<String>();
//            x.add("S");
//            x.add("A");
//            x.add("B");
//            Variable.setSymbolsAllowed(x);
//            Terminal a = new Terminal("a");
//            ter.add(a);
//            Terminal b = new Terminal("b");
//            ter.add(b);
//            Variable S = new Variable("S");
//            var.add(S);
//            Variable A = new Variable("A");
//            var.add(A);
//            Variable B = new Variable("B");
//            var.add(B);
//            prod.add(new Production(S, new Word(a,A)));
//            prod.add(new Production(A, new Word(null,null)));
//            prod.add(new Production(A, new Word(b,B)));
//            prod.add(new Production(B, new Word(a,A)));
//            System.out.println(new Conversor(new SRG(prod, var,ter ,S)).getFsa().toString());
//        } catch (InvalidSRG e) {
//            System.out.println(e.getMessage());
//        }


    }
}
