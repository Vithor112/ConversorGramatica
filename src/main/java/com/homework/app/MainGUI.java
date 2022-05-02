package com.homework.app;


import com.homework.app.fileHandling.SRGReader;

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
    private JFileChooser fc;
    private File SRGFile = null;

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
                    SRGFile = fc.getSelectedFile();
                    try {
                        SRGReader srgReader = new SRGReader(SRGFile);
                        SRGLabel.setText(srgReader.getSrg().getName());
                    } catch (Exception e){
                        SRGLabel.setText(e.getMessage());
                        System.out.println(e.getMessage());
                    }

                }
            }
        });

    }

}
