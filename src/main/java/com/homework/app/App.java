package com.homework.app;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.homework.app.GUI.MainGUI;

import javax.swing.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class App 
{
    public static void main( String[] args )
    {
        FlatDarculaLaf.setup();
        JFrame main = new JFrame("App");
        main.setContentPane(new MainGUI().panel1);
        main.setSize(500,700);
        main.setVisible(true);
        main.setDefaultCloseOperation(EXIT_ON_CLOSE);
        main.setLocationRelativeTo(null);
    }
}
