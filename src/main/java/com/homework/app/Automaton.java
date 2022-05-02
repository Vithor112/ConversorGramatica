package com.homework.app;

import com.homework.app.structs.FSA.FSA;

import javax.swing.*;

public class Automaton extends JFrame{
    private JTable ProdsJTable;
    private JLabel AFDNameLabel;
    private JLabel StatesJLabel;
    private JLabel SymbolsJLabel;
    private JLabel FinalStatesJLabel;
    private JLabel InitialStatesJLabel;
    private JPanel PanelContent;

    FSA fsa;

    public Automaton(FSA fsa){
        this.fsa = fsa;
        setSize(500,500);

        setContentPane(PanelContent);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
