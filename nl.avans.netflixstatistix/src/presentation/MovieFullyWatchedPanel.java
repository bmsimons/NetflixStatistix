package presentation;

import presentation.events.ChooseMovieItemListener;

import javax.swing.*;
import java.awt.*;

public class MovieFullyWatchedPanel extends JPanel {
    private UserInterface ui;
    private JTextArea movieStatisticsTextArea;
    private JComboBox<String> movieComboBox;

    // Display the statistics of a movie (who watched the movie fully?)
    public MovieFullyWatchedPanel(Dimension size, UserInterface ui){
        this.ui = ui;

        setPreferredSize(size);
        GridBagConstraints constraints = new GridBagConstraints();
        setLayout(new GridBagLayout());

        // Create components
        JLabel movieSelectLabel = new JLabel("Kies een film");

        movieComboBox = new JComboBox<>();
        movieComboBox.addItemListener(new ChooseMovieItemListener(this));

        movieStatisticsTextArea = new JTextArea(13, 35);
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

    public JComboBox<String> getMovieComboBox() {
        return this.movieComboBox;
    }

    public JTextArea getMovieStatisticsTextArea() {
        return this.movieStatisticsTextArea;
    }

    public UserInterface getUi() {
        return this.ui;
    }
}
