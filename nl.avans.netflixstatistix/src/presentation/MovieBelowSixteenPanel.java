package presentation;

import javax.swing.*;
import java.awt.*;

public class MovieBelowSixteenPanel extends JPanel {
    private UserInterface ui;
    private JLabel longestMovieLabel;

    // Display the movie with the longest duration with an age rating lower than 16
    public MovieBelowSixteenPanel(Dimension size, UserInterface ui){
        this.ui = ui;
        setPreferredSize(size);

        // Filler, if you see this in app, it means that you have no connection to the database!
        String movie = "Winnie the Pooh 3";
        longestMovieLabel = new JLabel("De langste film voor kinderen on 16 is "+movie+".");
        add(longestMovieLabel);

    }

    public JLabel getLongestMovieLabel() {
        return longestMovieLabel;
    }
}
