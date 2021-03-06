package data;

import data.connection.DBConnection;
import domain.Episode;
import domain.Series;
import domain.WatchedEpisode;
import domain.WatchedMovie;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class EpisodeDAO implements DAO<Episode> {

    private DBConnection conn;

    public EpisodeDAO() {
        conn = new DBConnection();
    }

    // Fetches a specific episode based on the given episodeID
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

    // Returns all episodes found in the database
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

    // Returns a hashmap with average watched percentages based on the given subscripionID (average percentage watched of the profiles associated with this subscription)
    public HashMap<Episode, Integer> getEpisodesWithAverageWatchedPerSubscription(int subscriptionID) {
        HashMap<Episode, Integer> collection = new HashMap<Episode, Integer>();
        HashMap<Episode, Integer> collectionCounter = new HashMap<Episode, Integer>();

        if (conn.openConnection()) {
            String query = "SELECT Episodes.*, WatchedEpisodes.Duration as watchedDuration FROM Profiles\n" +
                    "INNER JOIN WatchedEpisodes ON WatchedEpisodes.ProfileID = Profiles.ID\n" +
                    "INNER JOIN Episodes ON Episodes.ID = WatchedEpisodes.EpisodeID\n" +
                    "WHERE SubscriptionID = " + subscriptionID + "\n" +
                    "ORDER BY ID;";

            ResultSet result = conn.executeSQLSelectStatement(query);
            try {
                while (result.next()) {
                    Episode episode = new Episode(
                            result.getInt("episodeNumber"),
                            result.getString("title"),
                            result.getInt("duration"),
                            result.getInt("ID")
                    );

                    if (!collection.containsKey(episode)) {
                        collection.put(episode, result.getInt("watchedDuration"));
                        collectionCounter.put(episode, 1);
                    } else {
                        collection.put(episode, collection.get(episode) + result.getInt("watchedDuration"));
                        collectionCounter.put(episode, collectionCounter.get(episode) + 1);
                    }
                }

                for (Episode e: collectionCounter.keySet()) {
                    int amount = collectionCounter.get(e);

                    collection.put(e, collection.get(e) / amount);
                }
                conn.closeConnection();
                return collection;
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

        return null;
    }

    // Returns an arrayList that contains watch data of a specific episode
    public ArrayList<WatchedEpisode> getWatchedDataForEpisode(Episode episode) {
        ArrayList<WatchedEpisode> watchedData = new ArrayList<>();

        int episodeId = episode.getId();

        if (conn.openConnection()) {
            String query = "SELECT * FROM WatchedEpisodes WHERE EpisodeID = "+episodeId;

            ResultSet result = conn.executeSQLSelectStatement(query);
            try {
                while (result.next()) {
                    WatchedEpisode watchedEpisode = new WatchedEpisode(
                            result.getInt("ProfileID"),
                            result.getInt("EpisodeID"),
                            result.getInt("Duration")
                    );

                    if (watchedEpisode.getEpisodeID() == episodeId) {
                        watchedData.add(watchedEpisode);
                    }
                }

                conn.closeConnection();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

        return watchedData;
    }

    // Returns all the episodes from a specific series
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

    // Insert query for a watchedEpisode object, adds it the database
    public boolean addWatchedEpisode(WatchedEpisode watchedEpisode){
        if(conn.openConnection()){
            String query = "INSERT INTO WatchedEpisodes(ProfileID, EpisodeID, Duration) VALUES("+watchedEpisode.getProfileID()+","+watchedEpisode.getEpisodeID()+","+watchedEpisode.getDuration()+");";
            boolean result = conn.executeSQLInsertStatement(query);
            conn.closeConnection();
            return result;
        }
        return false;
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
