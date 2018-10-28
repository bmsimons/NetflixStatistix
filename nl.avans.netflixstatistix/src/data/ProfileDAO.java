package data;

import data.connection.DBConnection;
import domain.Profile;
import domain.Subscription;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfileDAO implements DAO<Profile> {

    private DBConnection conn;

    public ProfileDAO() {
        conn = new DBConnection();
    }

    // Returns profile based on the given id
    @Override
    public Profile get(int id) {
        //always open the connection when you want to contact the DB
        if (conn.openConnection()){
            //the query to get a single subscription
            String query = "SELECT * FROM Profiles WHERE ID = "+id;

            //the result from the query after querying
            ResultSet result = conn.executeSQLSelectStatement(query);
            try{
                //create a subscription with the result
                Profile profile = new Profile(
                        result.getString("Name"),
                        result.getInt("Age"),
                        result.getInt("ID")
                );

                //always close the connection when you're done with your query
                conn.closeConnection();

                //send the subscription back
                return profile;
            }catch (SQLException e){
                //if something went wrong, it shows here
                System.out.println(e.getStackTrace());
            }

        }

        return null;
    }

    // Returns all the profiles it was able to find in the database
    @Override
    public List<Profile> getAll() {
        List<Profile> profiles = new ArrayList<>();

        if (conn.openConnection()){
            String query = "SELECT * FROM Profiles";

            ResultSet result = conn.executeSQLSelectStatement(query);
            try{

                while(result.next()) {
                    Profile profile = new Profile(
                            result.getString("Name"),
                            result.getInt("Age"),
                            result.getInt("ID")
                    );

                    profiles.add(profile);
                }

                conn.closeConnection();

                return profiles;
            }catch (SQLException e){
                System.out.println(e);
            }

        }

        return null;
    }

    // Returns all the profiles that are associated with given subscription
    public ArrayList<Profile> getAllBySub(Subscription subscription) {
        ArrayList<Profile> profiles = new ArrayList<>();

        if (conn.openConnection()){
            String query = "SELECT * FROM Profiles WHERE SubscriptionID = " + subscription.getId();

            ResultSet result = conn.executeSQLSelectStatement(query);
            try{

                while(result.next()) {
                    Profile profile = new Profile(
                            result.getString("Name"),
                            result.getInt("Age"),
                            result.getInt("ID")
                    );

                    profiles.add(profile);
                }

                conn.closeConnection();

                return profiles;
            }catch (SQLException e){
                System.out.println(e);
            }

        }

        return null;
    }

    // Returns a profile based on a profile name and subscriptionID
    public Profile getProfileByNameAndSubscriberId(String profileName, Integer subscriberID) {
        if (conn.openConnection() && subscriberID != null) {
            String query = "SELECT * FROM Profiles WHERE SubscriptionID = " + subscriberID + " AND Name = '" + profileName + "';";

            ResultSet result = conn.executeSQLSelectStatement(query);

            try {
                while (result.next()) {
                    Profile profile = new Profile(
                            result.getString("Name"),
                            result.getInt("Age"),
                            result.getInt("ID")
                    );
                    conn.closeConnection();
                    return profile;
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

        return null;
    }

    // Inserts the profile into the database
    @Override
    public boolean insert(Profile profile) {
        if(conn.openConnection()){
            String query = "INSERT INTO Profiles(Name, Age, SubscriptionID) VALUES ('"+profile.getProfileName()+"',"+profile.getAge()+","+profile.getId()+");";
            boolean result = conn.executeSQLInsertStatement(query);
            conn.closeConnection();
            return(result);
        }
        return false;
    }

    @Override
    public boolean update(Profile profile) {
        return false;
    }

    @Override
    public boolean delete(Profile profile) {
        return false;
    }
}
