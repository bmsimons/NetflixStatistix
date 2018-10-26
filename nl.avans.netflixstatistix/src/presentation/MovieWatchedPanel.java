package presentation;

import presentation.events.SearchSubscriberActionListener;

import javax.swing.*;
import java.awt.*;

public class MovieWatchedPanel extends JPanel {
    private UserInterface ui;
    private JTextArea movieTextArea;
    private JTextField subscriptionTextField;

    public MovieWatchedPanel(Dimension size, UserInterface ui){
        this.ui = ui;

        setPreferredSize(size);
        GridBagConstraints constraints = new GridBagConstraints();
        setLayout(new GridBagLayout());

        subscriptionTextField = new JTextField();
        subscriptionTextField.setMinimumSize(new Dimension(150, 24));
        subscriptionTextField.setPreferredSize(new Dimension(220, 24));

        JButton searchButton = new JButton("Zoek Abonnee");
        searchButton.setMinimumSize(new Dimension(50,24));
        searchButton.addActionListener(new SearchSubscriberActionListener(this));

        movieTextArea = new JTextArea(13, 35);
        movieTextArea.setText("Selecteer een abonnee.");
        movieTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(movieTextArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

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

        constraints.gridy = 1;
        constraints.gridx = 0;
        constraints.gridwidth = 3;
        constraints.fill = GridBagConstraints.VERTICAL;
        add(scrollPane, constraints);
    }

    public UserInterface getUi() {
        return this.ui;
    }

    public JTextArea getMovieTextArea() {
        return this.movieTextArea;
    }

    public JTextField getSubscriptionTextField() {
        return this.subscriptionTextField;
    }
}
