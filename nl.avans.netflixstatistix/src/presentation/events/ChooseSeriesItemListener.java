package presentation.events;

import domain.Episode;
import presentation.SeriesPerSubscriptionPanel;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;

public class ChooseSeriesItemListener implements ItemListener {
    private SeriesPerSubscriptionPanel seriesPerSubscriptionPanel;

    public ChooseSeriesItemListener(SeriesPerSubscriptionPanel seriesPerSubscriptionPanel) {
        this.seriesPerSubscriptionPanel = seriesPerSubscriptionPanel;
    }

    // When this gets called, it will fetch the average watch times for given subscription and display them into the panel's textarea
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            String value = (String) e.getItem();

            HashMap<Episode, Integer> episodes = seriesPerSubscriptionPanel.getUi().getProgramManager().getEpisodesWithAverageWatchedPerSubscription(seriesPerSubscriptionPanel.getSelectedSubscriptionID());

            seriesPerSubscriptionPanel.getWatchedEpisodesTextArea().setText("");

            for (Episode episode : episodes.keySet()) {
                seriesPerSubscriptionPanel.getWatchedEpisodesTextArea().setText(seriesPerSubscriptionPanel.getWatchedEpisodesTextArea().getText()+"\n"+episode.getTitle()+" ("+(episodes.get(episode) * 100)/episode.getDuration()+"% seen)");
            }
        }
    }
}
