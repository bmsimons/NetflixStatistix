package data;

import data.connection.DBConnection;
import domain.Episode;
import domain.Series;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EpisodeDAO implements DAO<Episode> {

    private DBConnection conn;

    public EpisodeDAO() {
        conn = new DBConnection();
    }

    @Override
    public Episode get(int id) {

        //always open the connection when you want to contact the DB
        if (conn.openConnection()){
            //the query to get a single subscription
            String query = "SELECT * FROM Episodes WHERE id = "+id;

            //the result from the query after querying
            ResultSet result = conn.executeSQLSelectStatement(query);
            try{
                //create a subscription with the result
                Episode episode = new Episode(
                        result.getInt("EpisodeNumber"),
                        result.getString("Title"),
                        result.getInt("Duration"),
                        result.getInt("ID")
                );

                //always close the connection when you're done with your query
                conn.closeConnection();

                //send the subscription back
                return episode;
            }catch (SQLException e){
                //if something went wrong, it shows here
                System.out.println(e);
            }

        }

        return null;
    }

    @Override
    public ArrayList<Episode> getAll() {
        ArrayList<Episode> episodes = new ArrayList<>();

        if (conn.openConnection()){
            String query = "SELECT * FROM Episodes";

            ResultSet result = conn.executeSQLSelectStatement(query);
            try{

                while(result.next()) {
                    Episode episode = new Episode(
                            result.getInt("episodeNumber"),
                            result.getString("title"),
                            result.getInt("duration"),
                            result.getInt("ID")
                    );

                    episodes.add(episode);
                }

                conn.closeConnection();

                return episodes;
            }catch (SQLException e){
                System.out.println(e);
            }

        }

        return null;
    }

    public ArrayList<Episode> getAllBySeries(Series series) {
        ArrayList<Episode> episodes = new ArrayList<>();

        int seriesID = series.getId();

        if (conn.openConnection()){
            String query = "SELECT * FROM Episodes WHERE SeriesID = "+seriesID;

            ResultSet result = conn.executeSQLSelectStatement(query);
            try{
                while(result.next()) {
                    Episode episode = new Episode(
                            result.getInt("episodeNumber"),
                            result.getString("title"),
                            result.getInt("duration"),
                            result.getInt("ID")
                    );

                    episodes.add(episode);
                }

                conn.closeConnection();

                return episodes;
            }catch (SQLException e){
                System.out.println(e);
            }

        }

        return null;
    }

    @Override
    public boolean insert(Episode episode) {
        return false;
    }

    @Override
    public boolean update(Episode episode) {
        return false;
    }

    @Override
    public boolean delete(Episode episode) {
        return false;
    }
}
