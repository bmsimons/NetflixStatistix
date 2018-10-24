package presentation.events;

import domain.Series;
import domain.Subscription;
import presentation.SeriesPerSubscriptionPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SearchSubscriberActionListener implements ActionListener {
    private SeriesPerSubscriptionPanel seriesPerSubscriptionPanel;

    public SearchSubscriberActionListener(SeriesPerSubscriptionPanel seriesPerSubscriptionPanel) {
        this.seriesPerSubscriptionPanel = seriesPerSubscriptionPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<Subscription> subscriptions = seriesPerSubscriptionPanel.getUi().getSubscriptionManager().getSubscriptions();

        for (Subscription s : subscriptions) {
            if (seriesPerSubscriptionPanel.getSubscriptionTextField().getText().equals(s.getName())) {
                JOptionPane.showMessageDialog(null, "Found a subscriber with the name " + seriesPerSubscriptionPanel.getSubscriptionTextField().getText() + "!");

                int subscriptionID = s.getId();

                seriesPerSubscriptionPanel.setSelectedSubscriptionID(subscriptionID);

                Set<Integer> seriesIDs = seriesPerSubscriptionPanel.getUi().getSubscriptionManager().getAllSeriesForSubscriber(subscriptionID);

                ArrayList<Series> allSeries = seriesPerSubscriptionPanel.getUi().getProgramManager().getSeries();

                seriesPerSubscriptionPanel.getSeriesComboBox().removeAllItems();
                // eriesPerSubscriptionPanel.getWatchedEpisodesTextArea().setText("");

                for (Series series : allSeries) {
                    for (int seriesID : seriesIDs) {
                        if (series.getId() == seriesID) {
                            seriesPerSubscriptionPanel.getSeriesComboBox().addItem(series.getTitle());
                            // seriesPerSubscriptionPanel.getWatchedEpisodesTextArea().setText(seriesPerSubscriptionPanel.getWatchedEpisodesTextArea().getText() + "\n" + series.getTitle());

                            break;
                        }
                    }
                }

                return;
            }
        }

        JOptionPane.showMessageDialog(null, "Found no subscriber in the database :(");
    }
}
