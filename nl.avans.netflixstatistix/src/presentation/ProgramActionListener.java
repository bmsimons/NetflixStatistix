package presentation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgramActionListener implements ActionListener {
    private UserInterface ui;
    private JPanel centerPanel, topPanel;

    public ProgramActionListener(UserInterface ui, JPanel centerPanel, JPanel topPanel){
        this.ui = ui;
        this.centerPanel = centerPanel;
        this.topPanel = topPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ui.disableSelectedButton(topPanel, "Programma");
        ui.replaceCenterPanel(centerPanel,"Programma");
        ui.refresh();
    }
}
