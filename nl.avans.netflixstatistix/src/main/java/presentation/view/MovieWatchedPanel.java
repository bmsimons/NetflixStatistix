package main.java.presentation.view;

import javax.swing.*;
import java.awt.*;

public class MovieWatchedPanel extends JPanel {

    public MovieWatchedPanel(Dimension size){
        setPreferredSize(size);
        GridBagConstraints constraints = new GridBagConstraints();
        setLayout(new GridBagLayout());

        JTextField subscriptionTextField = new JTextField();
        subscriptionTextField.setMinimumSize(new Dimension(150, 24));
        subscriptionTextField.setPreferredSize(new Dimension(220, 24));

        JButton subscriptionSearchButton = new JButton("Zoek Abonnee");
        subscriptionSearchButton.setMinimumSize(new Dimension(50,24));

        JTextArea subscriptionMovieTextArea = new JTextArea("yo");
        subscriptionMovieTextArea.setEditable(false);
        subscriptionMovieTextArea.setMinimumSize(new Dimension(400, 250));
        subscriptionMovieTextArea.setPreferredSize(new Dimension(400, 250));

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

        constraints.gridy = 1;
        constraints.gridx = 0;
        constraints.gridwidth = 3;
        constraints.fill = GridBagConstraints.VERTICAL;
        add(subscriptionMovieTextArea, constraints);
    }
}
