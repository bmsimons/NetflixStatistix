package main.java.presentation.view;

import javax.swing.*;
import java.awt.*;

public class SubscriptionPanel extends JPanel {
    public SubscriptionPanel(Dimension size){
        setPreferredSize(size);
        GridBagConstraints constraints = new GridBagConstraints();
        setLayout(new GridBagLayout());

        JLabel subscriptionLabel = new JLabel("Accounts met minstens 1 profiel");

        // TODO: Fetch the subscriptions that have at least 1 profile assigned to them.

        JTextArea subscriptionTextArea = new JTextArea("yeeeeeeee");
        subscriptionTextArea.setPreferredSize(new Dimension(400,250));
        subscriptionTextArea.setEditable(false);

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(5,5,5,0);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(subscriptionLabel, constraints);

        constraints.gridy = 1;
        constraints.gridwidth = 3;
        constraints.fill = GridBagConstraints.VERTICAL;
        add(subscriptionTextArea, constraints);
    }
}
