package main.java.presentation.view;

import javax.swing.*;
import java.awt.*;

public class SeriesPerSubscriptionPanel extends JPanel {
    public SeriesPerSubscriptionPanel(Dimension size){
        setPreferredSize(size);
        GridBagConstraints constraints = new GridBagConstraints();
        setLayout(new GridBagLayout());

        JTextField subscriptionTextField = new JTextField();
        subscriptionTextField.setMinimumSize(new Dimension(150, 24));
        subscriptionTextField.setPreferredSize(new Dimension(220, 24));


        JButton subscriptionSearchButton = new JButton("Zoek Abonnee");
        subscriptionSearchButton.setMinimumSize(new Dimension(50,24));

        // TODO: Add ActionListener that fetches data which contains a list of watched series.

        JLabel subscriptionSeriesLabel = new JLabel("Selecteer een serie");

        String[] subscriptionSeriesTestData = {"a","b","c","d","e"};
        JComboBox<String> subscriptionSeriesComboBox = new JComboBox<String>(subscriptionSeriesTestData);

        // TODO: Add ActionListener that fetches data which contains a list with episodes + average watched percentage

        JTextArea subscriptionWatchedEpisodesTextArea = new JTextArea("ye");
        subscriptionWatchedEpisodesTextArea.setEditable(false);
        subscriptionWatchedEpisodesTextArea.setMinimumSize(new Dimension(400, 250));
        subscriptionWatchedEpisodesTextArea.setPreferredSize(new Dimension(400, 250));

        // Set the constraints, add the components to the panel
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.insets = new Insets(5,5,5,0);
        add(subscriptionTextField, constraints);

        constraints.gridx = 2;
        constraints.gridwidth = 1;
        add(subscriptionSearchButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        add(subscriptionSeriesLabel, constraints);

        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        add(subscriptionSeriesComboBox, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 3;
        constraints.fill = GridBagConstraints.VERTICAL;

        add(subscriptionWatchedEpisodesTextArea, constraints);
    }
}
