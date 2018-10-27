package presentation.events;

import domain.Episode;
import domain.Series;
import logic.ProgramManager;
import presentation.ProfileAddSeriesWatchedPanel;
import presentation.UserInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ProfileAddSeriesEpisodesActionListener implements ActionListener {
    private ProfileAddSeriesWatchedPanel panel;

    public ProfileAddSeriesEpisodesActionListener(ProfileAddSeriesWatchedPanel panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        panel.clearEpisodeComboBox();
        UserInterface ui = panel.getUi();
        ProgramManager pm = ui.getProgramManager();
        ArrayList<Episode> episodes = pm.getEpisodes((Series) panel.getSeriesComboBox().getSelectedItem());
        panel.setEpisodeComboBox(episodes);
    }
}
