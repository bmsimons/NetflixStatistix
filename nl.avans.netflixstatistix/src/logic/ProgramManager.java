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

    public ArrayList<Movie> getMovies(){

        MovieDAO mdao = new MovieDAO();

        movies = mdao.getAll();

        return movies;
    }

    public ArrayList<WatchedEpisode> getWatchedDataForEpisode(Episode episode) {
        EpisodeDAO edao = new EpisodeDAO();

        return edao.getWatchedDataForEpisode(episode);
    }

    public HashMap<Episode, Integer> getEpisodesWithAverageWatchedPerSubscription(int subscriptionID) {
        EpisodeDAO edao = new EpisodeDAO();

        return edao.getEpisodesWithAverageWatchedPerSubscription(subscriptionID);
    }

    public Set<Movie> getWatchedMoviesForSubscriber(Subscription s) {
        MovieDAO mdao = new MovieDAO();

        return mdao.getWatchedMoviesForSubscriber(s);
    }

    public Movie getLongestMovieUnder16() {
        MovieDAO mdao = new MovieDAO();

        return mdao.getLongestMovieUnder16();
    }

    public int getUserAmountFullyWatched(Movie movie){

        SubscriptionManager sm = new SubscriptionManager();

        ArrayList<Subscription> subs = sm.getSubscriptions();

        //TODO: need to be finished

        return 0;
    }

    public int getMovieFullyWatchedCount(Movie movie) {
        MovieDAO mdao = new MovieDAO();

        return mdao.getMovieFullyWatchedCount(movie);
    }

    public boolean addWatchedMovie(Movie movie, Profile profile, int duration){
        WatchedMovie wm = new WatchedMovie(profile.getId(), movie.getId(), duration);
        MovieDAO mdao =  new MovieDAO();
        return mdao.addWatchedMovie(wm);
    }

    public ArrayList<Episode> getEpisodes(Series series){
        EpisodeDAO edao = new EpisodeDAO();
        return edao.getAllBySeries(series);
    }

    public boolean addWatchedEpisode(Episode episode, Profile profile, int duration){
        WatchedEpisode we = new WatchedEpisode(profile.getId(), episode.getId(), duration);
        EpisodeDAO edao = new EpisodeDAO();
        return edao.addWatchedEpisode(we);
    }
}
