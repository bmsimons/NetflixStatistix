package presentation;

import javax.swing.*;
import java.awt.*;

public class MovieBelowSixteenPanel extends JPanel {
    private UserInterface ui;
    private JLabel longestMovieLabel;

    public MovieBelowSixteenPanel(Dimension size, UserInterface ui){
        this.ui = ui;
        setPreferredSize(size);

        // TODO: Fetch the longest movie with an age rating below 16
        String movie = "Winnie the Pooh 3";
        longestMovieLabel = new JLabel("De langste film voor kinderen on 16 is "+movie+".");
        add(longestMovieLabel);

    }

    public JLabel getLongestMovieLabel() {
        return longestMovieLabel;
    }
}
