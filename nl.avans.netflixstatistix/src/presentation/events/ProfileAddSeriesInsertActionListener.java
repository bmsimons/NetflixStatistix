package presentation.events;

import domain.Episode;
import domain.Profile;
import logic.ProgramManager;
import presentation.ProfileAddSeriesWatchedPanel;
import presentation.UserInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfileAddSeriesInsertActionListener implements ActionListener {

    private ProfileAddSeriesWatchedPanel panel;

    public ProfileAddSeriesInsertActionListener(ProfileAddSeriesWatchedPanel panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        UserInterface ui = this.panel.getUi();
        ProgramManager pm = ui.getProgramManager();

        int duration;
        if (!panel.getDurationTextFieldText().matches("-?(0|[1-9]\\d*)")){
            JOptionPane.showMessageDialog(null, "Tijdduur is ongeldig.");
            return;
        }
        duration = Integer.parseInt(panel.getDurationTextFieldText());
        Episode ep = panel.getSelectedEpisode();

        if (duration > ep.getDuration()){
            JOptionPane.showMessageDialog(null, "Gekeken lengte kan niet langer zijn dan die van de aflevering.");
            return;
        }

        if (panel.getSelectedProfile() == null){
            panel.setResult(false);
            return;
        }

        Profile p = panel.getSelectedProfile();

        panel.setResult(pm.addWatchedEpisode(ep, p, duration));
    }
}
