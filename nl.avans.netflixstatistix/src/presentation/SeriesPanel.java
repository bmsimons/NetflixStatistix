package presentation;

import domain.Episode;
import domain.Series;
import domain.WatchedEpisode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

// Panel that displays information about given series

public class SeriesPanel extends JPanel {
    private JComboBox<String> seriesComboBox;
    private JTextArea seriesAverageTextArea;
    private UserInterface ui;

    public SeriesPanel(Dimension size, UserInterface ui){
        this.ui = ui;

        setPreferredSize(new Dimension(size));
        GridBagConstraints constraints = new GridBagConstraints();
        setLayout(new GridBagLayout());

        // Center Panel Components
        JLabel seriesLabel = new JLabel("Selecteer serie");
        seriesComboBox = new JComboBox<String>();

        seriesComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String item = (String) e.getItem();

                    ArrayList<Series> series = ui.getProgramManager().getSeries();

                    for (Series s : series) {
                        if (s.getTitle().equals(item)) {
                            ArrayList<Episode> episodes = s.getEpisodes();

                            seriesAverageTextArea.setText("");

                            int watchedEpisodeTotalLength = 0;

                            for (Episode episode : episodes) {
                                int episodeDuration = episode.getDuration();

                                ArrayList<WatchedEpisode> watchedEpisodes = ui.getProgramManager().getWatchedDataForEpisode(episode);

                                if (watchedEpisodes.size() > 0) {

                                    for (WatchedEpisode we : watchedEpisodes) {
                                        watchedEpisodeTotalLength = watchedEpisodeTotalLength + we.getDuration();
                                    }

                                    int averageEpisodeWatchedDuration = watchedEpisodeTotalLength / watchedEpisodes.size();

                                    int percentageTotalDuration = ((averageEpisodeWatchedDuration * 100) / episodeDuration);

                                    seriesAverageTextArea.setText(seriesAverageTextArea.getText() + "\n" + episode.getTitle() + " (" + percentageTotalDuration + "% gemiddeld gekeken)");
                                } else {
                                    seriesAverageTextArea.setText(seriesAverageTextArea.getText() + "\n" + episode.getTitle());
                                }
                            }

                            break;
                        }
                    }
                }
            }
        });

        JLabel seriesAverageLabel = new JLabel("Gemiddeld % bekeken per aflevering");
        seriesAverageTextArea = new JTextArea(13, 35);
        seriesAverageTextArea.setText("Selecteer een serie.");
        seriesAverageTextArea.setDisabledTextColor(Color.BLACK);
        seriesAverageTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(seriesAverageTextArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        // Set the constraints, add the components to the panel
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.insets = new Insets(5,5,5,0);
        add(seriesLabel,constraints);

        constraints.gridx = 1;
        add(seriesComboBox, constraints);

        constraints.gridy = 2;
        constraints.gridx = 0;
        add(seriesAverageLabel, constraints);

        constraints.gridy = 3;
        constraints.gridwidth = 3;
        constraints.fill = GridBagConstraints.VERTICAL;
        add(scrollPane, constraints);
    }

    public JComboBox<String> getSeriesComboBox(){
        return seriesComboBox;
    }

    public void clearSeriesComboBox(){
        seriesComboBox.removeAllItems();
    }
}
