package data;

import data.connection.DBConnection;
import domain.Language;
import domain.Series;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SeriesDAO implements DAO<Series>{

    private DBConnection conn;

    public SeriesDAO() {
        conn = new DBConnection();
    }

    // Returns a specific series based on given id
    @Override
    public Series get(int id) {
        //always open the connection when you want to contact the DB
        if (conn.openConnection()){
            //the query to get a single subscription
            String query = "SELECT * FROM Series WHERE ID = "+id;

            //the result from the query after querying
            ResultSet result = conn.executeSQLSelectStatement(query);
            try{
                //create a subscription with the result
                Series series = new Series(
                        result.getInt("ID"),
                        result.getString("Title"),
                        result.getString("Genre"),
                        result.getInt("AgeIndication")
                );


                series.setLanguage(Language.valueOf(result.getString("languageCode")));

                //always close the connection when you're done with your query
                conn.closeConnection();

                //send the subscription back
                return series;
            }catch (SQLException e){
                //if something went wrong, it shows here
                System.out.println(e.getStackTrace());
            }

        }

        return null;
    }
    // Returns all the series it was able to find in the database
    @Override
    public ArrayList<Series> getAll() {
        ArrayList<Series> seriesList = new ArrayList<>();

        if (conn.openConnection()){
            String query = "SELECT * FROM Series";

            ResultSet result = conn.executeSQLSelectStatement(query);
            try{

                while(result.next()) {
                    Series series = new Series(
                            result.getInt("ID"),
                            result.getString("Title"),
                            result.getString("Genre"),
                            result.getInt("AgeIndication")
                    );

                    series.setLanguage(Language.valueOf(result.getString("languageCode")));

                    seriesList.add(series);
                }

                conn.closeConnection();

                return seriesList;
            }catch (SQLException e){
                System.out.println(e);
            }

        }

        return null;
    }

    @Override
    public boolean insert(Series series) {
        return false;
    }

    @Override
    public boolean update(Series series) {
        return false;
    }

    @Override
    public boolean delete(Series series) {
        return false;
    }
}
