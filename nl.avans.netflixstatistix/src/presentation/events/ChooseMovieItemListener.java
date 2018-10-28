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

    // When this screen gets displayed, it fetches all the movies that are watched and places them into the textarea
    @Override
    public void itemStateChanged(ItemEvent e) {
        String itemText = (String) e.getItem();

        ArrayList<Movie> movies = movieFullyWatchedPanel.getUi().getProgramManager().getMovies();

        String movieStatistics = "";

        for (Movie m : movies) {
            if (m.getTitle().equals(itemText)) {
                movieStatistics += "Titel: " + m.getTitle() + "\nGenre: " + m.getGenre() + "\nSpeeltijd: " + m.getDuration() + " minuten\nLeeftijdsindicatie: " + m.getAgeIndication() + "\nTaal: " + m.getLanguage() + "\n\nAantal kijkers dat deze film volledig gezien heeft: " + movieFullyWatchedPanel.getUi().getProgramManager().getMovieFullyWatchedCount(m);
                movieFullyWatchedPanel.getMovieStatisticsTextArea().setText(movieStatistics);

                return;
            }
        }


    }
}
