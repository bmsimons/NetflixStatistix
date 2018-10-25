package main.java.presentation.view;

import javax.swing.*;
import java.awt.*;

public class MovieFullyWatchedPanel extends JPanel {
    public MovieFullyWatchedPanel(Dimension size){
        setPreferredSize(size);
        GridBagConstraints constraints = new GridBagConstraints();
        setLayout(new GridBagLayout());

        JLabel movieSelectLabel = new JLabel("Kies een film");

        // TODO: Fetch a list containing all the movie titles
        JComboBox<String> movieComboBox = new JComboBox<>();

        // TODO: Fetch the statistics of the selected movie
        JTextArea movieStatisticsTextArea = new JTextArea(13, 35);
        movieStatisticsTextArea.setText("Selecteer een film.");
        movieStatisticsTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(movieStatisticsTextArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.insets = new Insets(5,5,5,0);
        add(movieSelectLabel, constraints);

        constraints.gridx = 2;
        add(movieComboBox, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 3;
        constraints.fill =  GridBagConstraints.VERTICAL;
        add(scrollPane, constraints);
    }
}
