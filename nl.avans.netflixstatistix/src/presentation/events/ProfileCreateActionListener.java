package presentation.events;

import domain.Profile;
import logic.SubscriptionManager;
import presentation.ProfileCreatePanel;
import presentation.UserInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfileCreateActionListener implements ActionListener {
    private ProfileCreatePanel panel;

    public ProfileCreateActionListener(ProfileCreatePanel panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        UserInterface ui = panel.getUi();
        SubscriptionManager sm = ui.getSubscriptionManager();

        int age;
        if (!panel.getAgeTextFieldText().matches("-?(0|[1-9]\\d*)")){
            JOptionPane.showMessageDialog(null, "Leeftijd is ongeldig.");
            return;
        }
        age = Integer.parseInt(panel.getAgeTextFieldText());
        if (age < 0 || age > 100){
            JOptionPane.showMessageDialog(null, "Leeftijd is ongeldig.");
            return;
        }
        String name = panel.getNameTextFieldText();

        if (name.isEmpty() || name.length() > 100){
            JOptionPane.showMessageDialog(null, "Naam is ongeldig.");
            return;
        }

        if (panel.getSelectedSubscription().getProfiles().size() > 5){
            JOptionPane.showMessageDialog(null, "Abonnee heeft al 5 profielen.");
            return;
        }

        Profile p = new Profile(name, age, panel.getSelectedSubscription().getId());
        panel.setResult(sm.addProfile(p, panel.getSelectedSubscription()));

    }
}
