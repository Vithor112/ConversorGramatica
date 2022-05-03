package com.homework.app;


import com.homework.app.fileHandling.SRGReader;
import com.homework.app.fileHandling.WordListReader;
import com.homework.app.structs.FSA.FSA;
import com.homework.app.structs.SRG.SRG;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class MainGUI extends JPanel {
    public JPanel panel1;
    private JButton insiraArquivoGLUDButton;
    private JButton insiraArquivoListaDeButton;
    private JLabel SRGLabel;
    private JButton AFDButton;
    private JFileChooser fc;
    private SRG srg = null;
    private FSA fsa = null;
    public MainGUI(){
         fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

         AFDButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent actionEvent) {
                 if (srg != null){
                     Conversor conversor = new Conversor(srg);
                     fsa = conversor.getFsa();
                     new Automaton(fsa);
                 }
             }
         });
         insiraArquivoListaDeButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent actionEvent) {
                 fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                 fc.setDialogTitle("Select Word List");
                 int returnValue  = fc.showDialog(null, "Select");
                 if (returnValue == JFileChooser.APPROVE_OPTION) {
                     System.out.println(fc.getSelectedFile().getPath());
                     File wordListFile = fc.getSelectedFile();
                     try {
                         WordListReader wordListReader = new WordListReader(wordListFile);
                     } catch (Exception e){
                         System.out.println(e.getMessage());
                     }

                 }
             }
         });
        insiraArquivoGLUDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fc.setDialogTitle("Select Right-Grammar");
                int returnValue  = fc.showDialog(null, "Select");
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    System.out.println(fc.getSelectedFile().getPath());
                    File SRGFile = fc.getSelectedFile();
                    try {
                        SRGReader srgReader = new SRGReader(SRGFile);
                        SRGLabel.setText(srgReader.getSrg().getName());
                        srg = srgReader.getSrg();
                    } catch (Exception e){
                        SRGLabel.setText(e.getMessage());
                        System.out.println(e.getMessage());
                    }

                }
            }
        });


    }

}
