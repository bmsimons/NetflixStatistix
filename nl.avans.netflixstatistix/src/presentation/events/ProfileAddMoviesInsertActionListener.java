package presentation.events;

import domain.Movie;
import domain.Profile;
import logic.ProgramManager;
import presentation.ProfileAddMoviesWatchedPanel;
import presentation.UserInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfileAddMoviesInsertActionListener implements ActionListener {

    private ProfileAddMoviesWatchedPanel panel;

    public ProfileAddMoviesInsertActionListener(ProfileAddMoviesWatchedPanel panel){
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
        Movie m = panel.getSelectedMovie();

        // Adds the watched movie & sets the result in view.
        if (m.getDuration() < duration){
            JOptionPane.showMessageDialog(null, "Gekeken lengte kan niet langer zijn dan die van de film.");
            return;
        }

        if (panel.getSelectedProfile() == null){
            panel.setResult(false);
            return;
        }

        Profile p = panel.getSelectedProfile();

        panel.setResult(pm.addWatchedMovie(m, p, duration));
    }
}
