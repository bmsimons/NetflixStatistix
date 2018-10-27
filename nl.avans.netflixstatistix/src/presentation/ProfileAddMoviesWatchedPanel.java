package presentation;

import domain.Movie;
import domain.Profile;
import presentation.events.ProfileAddMoviesInsertActionListener;
import presentation.events.ProfileAddMoviesSearchActionListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Set;

public class ProfileAddMoviesWatchedPanel extends JPanel {
    private UserInterface ui;
    private JTextField subscriptionTextField, durationTextField;
    private JLabel resultLabel, profileLabel, movieLabel, durationLabel;
    private JComboBox<Movie> movieComboBox;
    private JComboBox<Profile> profileComboBox;
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
        subscriptionSearchButton.addActionListener(new ProfileAddMoviesSearchActionListener(this));

        profileLabel = new JLabel("Selecteer een profiel");

        profileComboBox = new JComboBox<Profile>();
        // ComboBox disabled, enabled when subscriber is found.
        profileComboBox.setEnabled(false);

        movieLabel = new JLabel("Selecteer een film");
        // ComboBox gets filled by NavigationPanel, for whatever reason.
        movieComboBox = new JComboBox<Movie>();

        durationLabel = new JLabel("Lengte gekeken: ");

        // Make sure that you cannot add a duration longer than the movie / change it to max length.
        durationTextField = new JTextField();
        durationTextField.setPreferredSize(new Dimension(175, 24));

        // TODO Add an ActionListener that sends all the data to the apl. logic
        JButton addButton = new JButton("Voeg film toe!");
        addButton.addActionListener(new ProfileAddMoviesInsertActionListener(this));

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
        constraints.gridx = 1;  // Set this on 1, else the GUI starts to rescale due to the size of this label.
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

    public JComboBox<Movie> getMovieComboBox(){ return movieComboBox; }

    public String getSubscriptionTextFieldText(){
        return subscriptionTextField.getText();
    }

    public void setProfileComboBox(Set<Profile> profiles){
        for (Profile p : profiles){
            profileComboBox.addItem(p);
        }
    }

    public void clearProfileComboBox(){
        profileComboBox.removeAllItems();
    }

    public void enableProfileComboBox(boolean enabled){
        profileComboBox.setEnabled(enabled);
    }

    public void setMovieComboBox(ArrayList<Movie> movies){
        for (Movie m : movies){
            movieComboBox.addItem(m);
        }
    }

    public Movie getSelectedMovie(){
        return (Movie)movieComboBox.getSelectedItem();
    }

    public Profile getSelectedProfile(){
        return (Profile)profileComboBox.getSelectedItem();
    }

    public String getDurationTextFieldText(){
        return durationTextField.getText();
    }
}
