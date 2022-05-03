package com.homework.app.TableModels;

import com.homework.app.structs.FSA.FSA;
import com.homework.app.structs.FSA.State;
import com.homework.app.structs.FSA.Transition;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.HashMap;

public class TransictionModel extends AbstractTableModel {
    private FSA fsa;
    private ArrayList<State> states;
    private ArrayList<Character> symbols;
    public TransictionModel(FSA fsa, ArrayList<Character> symbols){
        this.fsa = fsa;
        this.symbols = symbols;
        this.states = new ArrayList<State>(fsa.getStates().values());
    }
    @Override
    public int getRowCount() {
        return states.size()+1;
    }

    @Override
    public int getColumnCount() {
        return symbols.size()+2;
    }

    @Override
    public Object getValueAt(int row, int column) {
        if (column == 0 && row == 0)
            return null;
        if (column == symbols.size()+1 && row == 0)
            return '&';
        if (column == 0)
            return states.get(row-1).getLabel();
        if (row == 0)
            return symbols.get(column-1);
        if (fsa.getTransitions().get(states.get(row-1)) != null)
            for (Transition transition : fsa.getTransitions().get(states.get(row-1))){
                if (column == symbols.size()+1){
                    if (transition.executeTransition(null) != null)
                        return transition.executeTransition(null).getLabel();
                    continue;
                }
                if (transition.executeTransition(symbols.get(column-1)) != null){
                    return transition.getNextState().getLabel();
                }
            }
        return null;
    }
}
