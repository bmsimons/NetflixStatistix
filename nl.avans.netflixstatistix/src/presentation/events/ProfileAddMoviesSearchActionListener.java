package presentation.events;

import domain.Profile;
import logic.SubscriptionManager;
import presentation.ProfileAddMoviesWatchedPanel;
import presentation.UserInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class ProfileAddMoviesSearchActionListener implements ActionListener {
    // Panel is used for calling inner functions.
    private ProfileAddMoviesWatchedPanel panel;

    public ProfileAddMoviesSearchActionListener(ProfileAddMoviesWatchedPanel panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Clear the ComboBox, in case we already used this function with a positive result.
        panel.clearProfileComboBox();

        // Fetch the UserInterface class, so we can fetch the manager.
        UserInterface ui = panel.getUi();
        SubscriptionManager s = ui.getSubscriptionManager();

        // Fetch the given input, transform it into a number.
        int subscriptionID = (panel.getSubscriptionTextFieldText().matches("-?(0|[1-9]\\d*)")? Integer.parseInt(panel.getSubscriptionTextFieldText()) : -1);

        // Fetch the set of profiles from the database
        // If the input isn't numeric, it will query with an ID of -1.
        Set<Profile> profiles = s.getProfilesForSubscriptionID((subscriptionID));

        // Check if we fetched anything.
        if (!profiles.isEmpty()){
            // Fill the ComboBox with fetched profiles.
            panel.setProfileComboBox(profiles);
        }else{
            // Display error if nothing was found.
            JOptionPane.showMessageDialog(null, "Geen abonnee gevonden met abonnement ID "+panel.getSubscriptionTextFieldText());
        }
        // Enable/disable based upon the profiles list being empty.
        panel.enableProfileComboBox(!profiles.isEmpty());
    }
}
