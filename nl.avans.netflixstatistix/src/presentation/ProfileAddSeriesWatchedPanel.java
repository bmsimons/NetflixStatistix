package presentation;

import domain.Episode;
import domain.Profile;
import domain.Series;
import presentation.events.ProfileAddSeriesEpisodesActionListener;
import presentation.events.ProfileAddSeriesInsertActionListener;
import presentation.events.ProfileAddSeriesSearchActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;

public class ProfileAddSeriesWatchedPanel extends JPanel {
    private UserInterface ui;
    private JTextField subscriptionTextField, durationTextField;
    private JLabel resultLabel, profileLabel, seriesLabel, episodeLabel, durationLabel;
    private JComboBox<Profile> profileComboBox;
    private JComboBox<Series> seriesComboBox;
    private JComboBox<Episode> episodeComboBox;

    public ProfileAddSeriesWatchedPanel(Dimension size, UserInterface ui){
        this.ui = ui;
        setPreferredSize(size);
        GridBagConstraints constraints = new GridBagConstraints();
        setLayout(new GridBagLayout());

        // Create the components
        JLabel subscriptionLabel = new JLabel("Abonnement nummer:");
        subscriptionTextField = new JTextField();
        subscriptionTextField.setPreferredSize(new Dimension(175, 24));

        JButton subscriptionSearchButton = new JButton("Haal profielen op!");
        subscriptionSearchButton.addActionListener(new ProfileAddSeriesSearchActionListener(this));

        profileLabel = new JLabel("Selecteer een profiel");
        profileComboBox = new JComboBox<Profile>();
        // ComboBox disabled, enabled when subscriber is found.
        profileComboBox.setEnabled(false);

        seriesLabel = new JLabel("Selecteer een serie");
        seriesComboBox = new JComboBox<Series>();
        seriesComboBox.addActionListener(new ProfileAddSeriesEpisodesActionListener(this));

        episodeLabel = new JLabel("Selecteer een aflevering");
        episodeComboBox = new JComboBox<Episode>();
        durationLabel = new JLabel("Lengte gekeken: ");

        // Make sure that you cannot add a duration longer than the movie / change it to max length.
        durationTextField = new JTextField();
        durationTextField.setPreferredSize(new Dimension(175, 24));

        JButton addButton = new JButton("Voeg aflevering toe!");
        addButton.addActionListener(new ProfileAddSeriesInsertActionListener(this));
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
        add(seriesLabel, constraints);

        constraints.gridx = 1;
        add(seriesComboBox, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        add(episodeLabel, constraints);

        constraints.gridx = 1;
        add(episodeComboBox, constraints);

        constraints.gridx = 0;
        constraints.gridy = 5;
        add(durationLabel, constraints);

        constraints.gridx = 1;
        add(durationTextField, constraints);

        constraints.gridy = 6;
        constraints.gridx = 0;
        add(addButton, constraints);

        constraints.gridx = 1;
        constraints.gridy = 7;
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

    public JComboBox<Series> getSeriesComboBox(){ return seriesComboBox; }

    public void clearProfileComboBox(){
        profileComboBox.removeAllItems();
    }

    public void enableProfileComboBox(boolean enabled){
        profileComboBox.setEnabled(enabled);
    }

    public String getSubscriptionTextFieldText(){
        return subscriptionTextField.getText();
    }

    public void setProfileComboBox(Set<Profile> profiles){
        for (Profile p : profiles){
            profileComboBox.addItem(p);
        }
    }

    public JComboBox<Episode> getEpisodeComboBox(){ return episodeComboBox; }
    public void setEpisodeComboBox(ArrayList<Episode> episodes){
        for (Episode e : episodes){
            episodeComboBox.addItem(e);
        }
    }

    public void clearEpisodeComboBox(){
        episodeComboBox.removeAllItems();
    }

    public void setSeriesComboBox(ArrayList<Series> series){
        for (Series s : series){
            seriesComboBox.addItem(s);
        }
    }
    public String getDurationTextFieldText(){
        return durationTextField.getText();
    }

    public Profile getSelectedProfile(){
        return (Profile)profileComboBox.getSelectedItem();
    }

    public Episode getSelectedEpisode() { return (Episode)episodeComboBox.getSelectedItem(); }
}
