package main.java.presentation.view;

import javax.swing.*;
import java.awt.*;

public class MovieBelowSixteenPanel extends JPanel {
    public MovieBelowSixteenPanel(Dimension size){
        setPreferredSize(size);

        // TODO: Fetch the longest movie with an age rating below 16
        String movie = "Winnie the Pooh 3";
        JLabel longestMovieLabel = new JLabel("De langste film voor kinderen on 16 is "+movie+".");
        add(longestMovieLabel);

    }
}
