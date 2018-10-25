package data;

import data.connection.DBConnection;
import domain.Subscription;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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