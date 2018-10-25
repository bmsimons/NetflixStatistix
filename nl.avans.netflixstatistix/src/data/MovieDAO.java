package data;

import data.connection.DBConnection;
import domain.Language;
import domain.Movie;
import domain.Profile;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO implements DAO<Movie>{

    private DBConnection conn;

    public MovieDAO() {
        conn = new DBConnection();
    }

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
}
