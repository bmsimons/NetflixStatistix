package data;

import data.connection.DBConnection;
import domain.Profile;
import domain.Subscription;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubscriptionDAO implements DAO<Subscription> {

    private DBConnection conn;

    public SubscriptionDAO() {
        conn = new DBConnection();
    }

    @Override
    public Subscription get(int id) {

        //always open the connection when you want to contact the DB
        if (conn.openConnection()){
            //the query to get a single subscription
            String query = "SELECT * FROM Subscriptions WHERE ID = "+id;

            //the result from the query after querying
            ResultSet result = conn.executeSQLSelectStatement(query);
            try{
                //create a subscription with the result
                Subscription subscription = new Subscription(
                        result.getString("Name"),
                        result.getString("StreetName"),
                        result.getString("City"),
                        result.getInt("HouseNumber"),
                        result.getString("Addition"),
                        result.getInt("ID")
                );

                //always close the connection when you're done with your query
                conn.closeConnection();

                //send the subscription back
                return subscription;
            }catch (SQLException e){
                //if something went wrong, it shows here
                System.out.println(e);
            }

        }

        return null;
    }

    @Override
    public ArrayList<Subscription> getAll() {

        ArrayList<Subscription> subscriptions = new ArrayList<>();

        if (conn.openConnection()){
            String query = "SELECT * FROM Subscriptions";

            ResultSet result = conn.executeSQLSelectStatement(query);
            try{

                while(result.next()) {
                    Subscription subscription = new Subscription(
                            result.getString("Name"),
                            result.getString("StreetName"),
                            result.getString("City"),
                            result.getInt("HouseNumber"),
                            result.getString("Addition"),
                            result.getInt("ID")
                    );

                    subscriptions.add(subscription);
                }

                conn.closeConnection();

                return subscriptions;
            }catch (SQLException e){
                System.out.println(e);
            }

        }

        return null;
    }

    public Set<Integer> getAllSeriesForSubscriber(int subscriberID) {
        Set<Integer> seriesIDs = new HashSet<Integer>();

        if (conn.openConnection()) {
            String query = "SELECT DISTINCT EpisodeID FROM WatchedEpisodes\n" +
                    "INNER JOIN Profiles ON Profiles.ID = WatchedEpisodes.ProfileID\n" +
                    "INNER JOIN Episodes ON Episodes.ID = EpisodeID\n" +
                    "WHERE SubscriptionID = " + subscriberID + ";";

            ResultSet result = conn.executeSQLSelectStatement(query);
            try {
                while(result.next()) {
                    seriesIDs.add(result.getInt("EpisodeID"));
                }

                conn.closeConnection();

                return seriesIDs;
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

        return null;
    }

    public Set<Profile> getProfilesForSubscription(Subscription s) {
        Set<Profile> profiles = new HashSet<Profile>();

        if (conn.openConnection()) {
            String query = "SELECT * FROM Profiles WHERE SubscriptionID = " + s.getId() + ";";

            ResultSet result = conn.executeSQLSelectStatement(query);

            try {
                while (result.next()) {
                    profiles.add(new Profile(
                                result.getString("Name"),
                                result.getInt("Age"),
                                result.getInt("ID")
                            )
                    );
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

        return profiles;
    }

    @Override
    public boolean insert(Subscription subscription) {
        return false;
    }

    @Override
    public boolean update(Subscription subscription) {
        return false;
    }

    @Override
    public boolean delete(Subscription subscription) {
        return false;
    }
}
