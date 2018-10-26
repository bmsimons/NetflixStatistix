package presentation.events;

import domain.Profile;
import presentation.ProfilePanel;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ChooseProfileItemListener implements ItemListener {

    ProfilePanel profilePanel;

    public ChooseProfileItemListener(ProfilePanel profilePanel) {
        this.profilePanel = profilePanel;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        String profileName = (String) e.getItem();

        Profile profile = profilePanel.getUi().getSubscriptionManager().getProfileByNameAndSubscriberId(profileName, profilePanel.getSubscriberID());

        if (profile != null) {
            profilePanel.getResultTextArea().setText("Naam: " + profile.getProfileName() + "\nLeeftijd: " + profile.getAge());
        }
    }
}