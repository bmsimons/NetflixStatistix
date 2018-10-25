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


        JButton searchButton = new JButton("Zoek Abonnee");
        searchButton.setMinimumSize(new Dimension(50,24));

        // TODO: Add ActionListener that fetches data which contains a list of watched series.

        JLabel seriesLabel = new JLabel("Selecteer een serie");

        String[] seriesTestData = {"a","b","c","d","e"};
        JComboBox<String> seriesComboBox = new JComboBox<String>(seriesTestData);

        // TODO: Add ActionListener that fetches data which contains a list with episodes + average watched percentage

        JTextArea watchedEpisodesTextArea = new JTextArea(13, 35);
        watchedEpisodesTextArea.setText("Selecteer een abonnee & serie.");
        watchedEpisodesTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(watchedEpisodesTextArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

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
        add(searchButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        add(seriesLabel, constraints);

        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        add(seriesComboBox, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 3;
        constraints.fill = GridBagConstraints.VERTICAL;

        add(scrollPane, constraints);
    }
}
