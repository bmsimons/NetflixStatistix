package main.java.presentation.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgramActionListener implements ActionListener {
    private UserInterface ui;
    private JPanel centerPanel, topPanel;

    public ProgramActionListener(UserInterface ui){
        this.ui = ui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ui.disableButton("Programma");
        ui.replaceContentPanel("Programma");
        ui.refresh();
    }
}
