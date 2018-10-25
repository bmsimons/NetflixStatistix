package presentation.events;

import domain.Movie;
import presentation.MovieFullyWatchedPanel;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class ChooseMovieItemListener implements ItemListener {

    private MovieFullyWatchedPanel movieFullyWatchedPanel;

    public ChooseMovieItemListener(MovieFullyWatchedPanel movieFullyWatchedPanel) {
        this.movieFullyWatchedPanel = movieFullyWatchedPanel;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        String itemText = (String) e.getItem();

        ArrayList<Movie> movies = movieFullyWatchedPanel.getUi().getProgramManager().getMovies();

        String movieStatistics = "";

        for (Movie m : movies) {
            if (m.getTitle().equals(itemText)) {
                movieStatistics += "Titel: " + m.getTitle() + "\nGenre: " + m.getGenre() + "\nSpeeltijd: " + m.getDuration() + " minuten\nLeeftijdsindicatie: " + m.getAgeIndication() + "\nTaal: " + m.getLanguage();
                movieFullyWatchedPanel.getMovieStatisticsTextArea().setText(movieStatistics);

                return;
            }
        }


    }
}
