package presentation;

import javax.swing.*;
import java.awt.*;

public class ProfileAddMoviesWatchedPanel extends JPanel {
    private UserInterface ui;
    private JTextField subscriptionTextField, durationTextField;
    private JLabel resultLabel, profileLabel, movieLabel, durationLabel;
    private JComboBox<String> profileComboBox, movieComboBox;

    public ProfileAddMoviesWatchedPanel(Dimension size, UserInterface ui){
        this.ui = ui;
        setPreferredSize(size);
        GridBagConstraints constraints = new GridBagConstraints();
        setLayout(new GridBagLayout());

        // Create the components
        JLabel subscriptionLabel = new JLabel("Abonnement nummer:");
        subscriptionTextField = new JTextField();
        subscriptionTextField.setPreferredSize(new Dimension(175, 24));

        JButton subscriptionSearchButton = new JButton("Haal profielen op!");

        profileLabel = new JLabel("Selecteer een profiel");

        // TODO: Add an ActionListener that fetches the profiles related to given subscriber.
        String[] testProfiles = {"Profiel 1","Profiel 2","Profiel 3","Profiel 4","Profiel 5"};
        profileComboBox = new JComboBox<String>(testProfiles);
        // ComboBox disabled, enable when subscriber is found.
        profileComboBox.setEnabled(false);

        movieLabel = new JLabel("Selecteer een film");

        // TODO: Fetch the list of movies
        String[] testMovies = {"Winnie the Pooh 1","Winnie the Pooh 2","Winnie the Pooh 3"};
        movieComboBox = new JComboBox<String>(testMovies);

        durationLabel = new JLabel("Lengte gekeken: ");

        // Make sure that you cannot add a duration longer than the movie / change it to max length.
        durationTextField = new JTextField();
        durationTextField.setPreferredSize(new Dimension(175, 24));

        // TODO Add an ActionListener that sends all the data to the apl. logic
        JButton addButton = new JButton("Voeg film toe!");

        // TODO set resultLabel's text to be a result of whether the movie got added or not
        resultLabel = new JLabel();

        // Set the constraints, add components to panel
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(5,5,5,0);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(subscriptionLabel, constraints);

        constraints.gridx = 1;
        add(subscriptionTextField, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        add(subscriptionSearchButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        add(profileLabel, constraints);

        constraints.gridx = 1;
        add(profileComboBox, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        add(movieLabel, constraints);

        constraints.gridx = 1;
        add(movieComboBox, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        add(durationLabel, constraints);

        constraints.gridx = 1;
        add(durationTextField, constraints);

        constraints.gridy = 5;
        constraints.gridx = 0;
        add(addButton, constraints);

        constraints.gridy = 6;
        add(resultLabel, constraints);
    }

    public void setResult(boolean success){
        String resultText = "Het toevoegen het programma is ";
        resultText += (success? "gelukt." : "mislukt.");
        resultLabel.setText(resultText);
    }

    public void clear(){
        subscriptionTextField.setText("");
        durationTextField.setText("");
    }

    public UserInterface getUi(){ return this.ui; }
}
