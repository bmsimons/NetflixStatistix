package logic;

import data.EpisodeDAO;
import data.MovieDAO;
import data.SeriesDAO;
import domain.Movie;
import domain.Series;
import domain.Subscription;

import java.util.ArrayList;

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

    public int getUserAmountFullyWatched(Movie movie){

        SubscriptionManager sm = new SubscriptionManager();

        ArrayList<Subscription> subs = sm.getSubscriptions();

        //TODO: need to be finished

        return 0;
    }
}
