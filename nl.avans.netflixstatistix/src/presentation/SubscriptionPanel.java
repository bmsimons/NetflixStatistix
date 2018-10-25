package presentation;

import javax.swing.*;
import java.awt.*;

public class SubscriptionPanel extends JPanel {
    private UserInterface ui;
    private JTextArea subscriptionTextArea;

    public SubscriptionPanel(Dimension size, UserInterface ui){
        this.ui = ui;

        setPreferredSize(size);
        GridBagConstraints constraints = new GridBagConstraints();
        setLayout(new GridBagLayout());

        JLabel subscriptionLabel = new JLabel("Accounts met minstens 1 profiel");

        // TODO: Fetch the subscriptions that have at least 1 profile assigned to them.

        subscriptionTextArea = new JTextArea(13, 35);
        subscriptionTextArea.setText("--- TEXT ---");
        subscriptionTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(subscriptionTextArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

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
        add(scrollPane, constraints);
    }

    public JTextArea getSubscriptionTextArea() {
        return this.subscriptionTextArea;
    }
}
