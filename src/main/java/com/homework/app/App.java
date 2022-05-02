package com.homework.app;

import javax.swing.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        JFrame main = new JFrame("App");
        main.setContentPane(new mainGUI().panel1);
        main.setSize(500,700);
        main.setVisible(true);

    }
}
