package com.homework.app;

import com.homework.app.structs.FSA.Alphabet;
import com.homework.app.structs.FSA.FSA;
import com.homework.app.structs.FSA.State;

import javax.swing.*;
import java.util.stream.Collectors;

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

        fillLabels();
    }


    private void fillLabels(){
        AFDNameLabel.setText(fsa.getName());
        StatesJLabel.setText(fsa.getStates().values().stream().map(State::getLabel).collect(Collectors.joining(",")));
        FinalStatesJLabel.setText(fsa.getFinalState().getLabel());
        InitialStatesJLabel.setText(fsa.getInitialState().getLabel());
        SymbolsJLabel.setText(Alphabet.getSymbolsAllowed().stream().map(Object::toString).collect(Collectors.joining(",")));
    }
}
