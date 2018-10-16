package main.java.presentation.view;

import javax.swing.*;
import java.awt.*;

public class AccountPanel extends JPanel {
    public AccountPanel(Dimension size){
        setPreferredSize(size);
        GridBagConstraints constraints = new GridBagConstraints();
        setLayout(new GridBagLayout());

        JLabel accountLabel = new JLabel("Accounts met minstens 1 profiel");

        // TODO: Fetch the accounts / subscriptions that have at least 1 profile assigned to them.

        JTextArea accountTextArea = new JTextArea("yeeeeeeee");
        accountTextArea.setPreferredSize(new Dimension(400,250));
        accountTextArea.setEditable(false);

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(5,5,5,0);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(accountLabel, constraints);

        constraints.gridy = 1;
        constraints.gridwidth = 3;
        constraints.fill = GridBagConstraints.VERTICAL;
        add(accountTextArea, constraints);
    }
}
