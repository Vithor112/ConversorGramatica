package com.homework.app;

import jdk.jfr.internal.tool.Main;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JPanel {
    public JPanel panel1;
    private JButton insiraArquivoGLUDButton;
    private JButton insiraArquivoListaDeButton;
    private JFileChooser fc;

    public MainGUI(){
         fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        insiraArquivoGLUDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fc.setDialogTitle("Select Right-Grammar");
                int returnValue  = fc.showDialog(null, "Select");
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    System.out.println(fc.getSelectedFile().getPath());
                    fc.getSelectedFile();
                }
            }
        });
    }
}
