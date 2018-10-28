package data;

import data.connection.DBConnection;
import domain.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MovieDAO implements DAO<Movie>{

    private DBConnection conn;

    public MovieDAO() {
        conn = new DBConnection();
    }


    // Returns a specific movie based on given ID
    @Override
    public Movie get(int id) {
        //always open the connection when you want to contact the DB
        if (conn.openConnection()){
            //the query to get a single subscription
            String query = "SELECT * FROM Movies WHERE id = "+id;

            //the result from the query after querying
            ResultSet result = conn.executeSQLSelectStatement(query);
            try{
                //create a subscription with the result
                Movie movie = new Movie(
                        result.getInt("ID"),
                        result.getString("Title"),
                        result.getString("Genre"),
                        result.getInt("ageIndication"),
                        result.getInt("Duration")
                );

                movie.setLanguage(Language.valueOf(result.getString("languageCode")));

                //always close the connection when you're done with your query
                conn.closeConnection();

                //send the subscription back
                return movie;
            }catch (SQLException e){
                //if something went wrong, it shows here
                System.out.println(e.getStackTrace());
            }

        }

        return null;
    }

    // Returns all movies found in the database
    @Override
    public ArrayList<Movie> getAll() {
        ArrayList<Movie> movieList = new ArrayList<>();

        if (conn.openConnection()){
            String query = "SELECT * FROM Movies";

            ResultSet result = conn.executeSQLSelectStatement(query);
            try{

                while(result.next()) {
                    Movie movie = new Movie(
                            result.getInt("ID"),
                            result.getString("Title"),
                            result.getString("Genre"),
                            result.getInt("ageIndication"),
                            result.getInt("Duration")
                    );

                    movie.setLanguage(Language.valueOf(result.getString("languageCode")));

                    movieList.add(movie);
                }

                conn.closeConnection();

                return movieList;
            }catch (SQLException e){
                System.out.println(e);
            }

        }

        return null;
    }

    @Override
    public boolean insert(Movie movie) {
        return false;
    }

    @Override
    public boolean update(Movie movie) {
        return false;
    }

    @Override
    public boolean delete(Movie movie) {
        return false;
    }

    // Returns an list containing the movies that were watched by a specific profile
    public ArrayList<Movie> getMoviesWatchedBy(Profile profile){
        ArrayList<Movie> movieList = new ArrayList<>();

        if (conn.openConnection()){
            String query = "SELECT * FROM Movies WHERE ID IN (SELECT MovieID FROM WatchedMovies WHERE ProfileID = "+ profile.getId()+")";

            ResultSet result = conn.executeSQLSelectStatement(query);
            try{

                while(result.next()) {
                    Movie movie = new Movie(
                            result.getInt("ID"),
                            result.getString("Title"),
                            result.getString("Genre"),
                            result.getInt("ageIndication"),
                            result.getInt("Duration")
                    );

                    movie.setLanguage(Language.valueOf(result.getString("languageCode")));

                    movieList.add(movie);
                }

                conn.closeConnection();

                return movieList;
            }catch (SQLException e){
                System.out.println(e);
            }

        }

        return null;
    }

    // Returns a set of movies that were watched by profiles associated with a specific subscription
    public Set<Movie> getWatchedMoviesForSubscriber(Subscription s) {
        Set<Movie> movieList = new HashSet<>();

        if (conn.openConnection()) {
            String query = "SELECT Movies.* FROM WatchedMovies\n" +
                    "INNER JOIN Profiles ON Profiles.ID = WatchedMovies.ProfileID\n" +
                    "INNER JOIN Movies ON Movies.ID = WatchedMovies.MovieID\n" +
                    "WHERE SubscriptionID = " + s.getId();

            ResultSet result = conn.executeSQLSelectStatement(query);

            try {
                while (result.next()) {
                    Movie movie = new Movie(
                            result.getInt("ID"),
                            result.getString("Title"),
                            result.getString("Genre"),
                            result.getInt("ageIndication"),
                            result.getInt("Duration")
                    );

                    movie.setLanguage(Language.valueOf(result.getString("languageCode")));

                    movieList.add(movie);
                }
                conn.closeConnection();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

        return movieList;
    }

    // returns a movie that is the longest in duration and has an age-rating of 16- or below
    public Movie getLongestMovieUnder16() {
        if (conn.openConnection()) {
            String query = "SELECT * FROM Movies WHERE ageIndication < 16 AND Duration = (SELECT MAX(Duration) FROM Movies);";

            ResultSet result = conn.executeSQLSelectStatement(query);

            try {
                while (result.next()) {
                    Movie movie = new Movie(
                            result.getInt("ID"),
                            result.getString("Title"),
                            result.getString("Genre"),
                            result.getInt("ageIndication"),
                            result.getInt("Duration")
                    );

                    movie.setLanguage(Language.valueOf(result.getString("languageCode")));
                    conn.closeConnection();
                    return movie;
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

        return null;
    }

    // Returns an integer that displays the amount of times the movie has been fully watched
    public Integer getMovieFullyWatchedCount(Movie movie) {
        Integer movieWatchCounter = 0;

        if (conn.openConnection()) {
            String query = "SELECT * FROM Movies INNER JOIN WatchedMovies ON WatchedMovies.MovieID = Movies.ID AND WatchedMovies.Duration = Movies.Duration WHERE Movies.ID = " + movie.getId() + ";";

            ResultSet result = conn.executeSQLSelectStatement(query);

            try {
                while (result.next()) {
                    movieWatchCounter++;
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        conn.closeConnection();
        return movieWatchCounter;
    }

    // Insert for watched movies, adds it the database
    public boolean addWatchedMovie(WatchedMovie watchedMovie){
        if(conn.openConnection()){
            String query = "INSERT INTO WatchedMovies(ProfileID, MovieID, Duration) VALUES("+watchedMovie.getProfileID()+","+watchedMovie.getMovieID()+","+watchedMovie.getDuration()+");";
            boolean result = conn.executeSQLInsertStatement(query);
            conn.closeConnection();
            return result;
        }
        return false;
    }
}
