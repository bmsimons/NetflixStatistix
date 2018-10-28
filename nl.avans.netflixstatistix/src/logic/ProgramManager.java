package logic;

import data.EpisodeDAO;
import data.MovieDAO;
import data.SeriesDAO;
import domain.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class ProgramManager {

    private ArrayList<Series> series;
    private ArrayList<Movie>  movies;

    public ProgramManager() {
        series = new ArrayList<>();
        movies = new ArrayList<>();
    }

    // Fetches list of series from database, returns them.
    public ArrayList<Series> getSeries(){

        //create the seriesDAO
        SeriesDAO sdao = new SeriesDAO();

        //get all the series and add them to the local arraylist
        series = sdao.getAll();

        //add the episodes to each series
        for (Series s : series){
            EpisodeDAO edao = new EpisodeDAO();

            s.setEpisodes(edao.getAllBySeries(s));
        }

        //return the local series arraylist
        return series;
    }

    // Fetches list of movies from the database, returns them.
    public ArrayList<Movie> getMovies(){

        MovieDAO mdao = new MovieDAO();

        movies = mdao.getAll();

        return movies;
    }

    // Returns a list containing watched data of a specific episode from the database
    public ArrayList<WatchedEpisode> getWatchedDataForEpisode(Episode episode) {
        EpisodeDAO edao = new EpisodeDAO();

        return edao.getWatchedDataForEpisode(episode);
    }
    // Returns a hashMap containing the average watched percentages of a subscription from the database
    public HashMap<Episode, Integer> getEpisodesWithAverageWatchedPerSubscription(int subscriptionID) {
        EpisodeDAO edao = new EpisodeDAO();

        return edao.getEpisodesWithAverageWatchedPerSubscription(subscriptionID);
    }

    // returns a set of movies that were watched by profiles associated with the given subscription
    public Set<Movie> getWatchedMoviesForSubscriber(Subscription s) {
        MovieDAO mdao = new MovieDAO();

        return mdao.getWatchedMoviesForSubscriber(s);
    }

    // Returns the longest movie with an age rating below 16 from the database
    public Movie getLongestMovieUnder16() {
        MovieDAO mdao = new MovieDAO();

        return mdao.getLongestMovieUnder16();
    }

    // Returns the amount of people that have fully watched the given movie
    public int getMovieFullyWatchedCount(Movie movie) {
        MovieDAO mdao = new MovieDAO();

        return mdao.getMovieFullyWatchedCount(movie);
    }

    // Prepares the watchedMovie object, sends it to the database object for insertion
    public boolean addWatchedMovie(Movie movie, Profile profile, int duration){
        WatchedMovie wm = new WatchedMovie(profile.getId(), movie.getId(), duration);
        MovieDAO mdao =  new MovieDAO();
        return mdao.addWatchedMovie(wm);
    }

    // Returns an list of episodes associated with a given series
    public ArrayList<Episode> getEpisodes(Series series){
        EpisodeDAO edao = new EpisodeDAO();
        return edao.getAllBySeries(series);
    }

    // Prepares the watchedEpisode object, sends it to the database object for insertion
    public boolean addWatchedEpisode(Episode episode, Profile profile, int duration){
        WatchedEpisode we = new WatchedEpisode(profile.getId(), episode.getId(), duration);
        EpisodeDAO edao = new EpisodeDAO();
        return edao.addWatchedEpisode(we);
    }
}
