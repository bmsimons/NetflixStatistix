package data;

import data.connection.DBConnection;
import domain.Profile;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfileDAO implements DAO<Profile> {

    private DBConnection conn;

    public ProfileDAO() {
        conn = new DBConnection();
    }

    @Override
    public Profile get(int id) {
        //always open the connection when you want to contact the DB
        if (conn.openConnection()){
            //the query to get a single subscription
            String query = "SELECT * FROM Profiles WHERE id = "+id;

            //the result from the query after querying
            ResultSet result = conn.executeSQLSelectStatement(query);
            try{
                //create a subscription with the result
                Profile profile = new Profile(
                        result.getString("name"),
                        result.getInt("age"),
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

    @Override
    public List<Profile> getAll() {
        List<Profile> profiles = new ArrayList<>();

        if (conn.openConnection()){
            String query = "SELECT * FROM Profiles";

            ResultSet result = conn.executeSQLSelectStatement(query);
            try{

                while(result.next()) {
                    Profile profile = new Profile(
                            result.getString("name"),
                            result.getInt("age"),
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

    @Override
    public boolean insert(Profile profile) {
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
