package data;

import data.connection.DBConnection;
import domain.Language;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LanguageDAO implements DAO<Language> {

    private DBConnection conn;

    public LanguageDAO() {
        conn = new DBConnection();
    }

    @Override
    public Language get(int id) {
        //always open the connection when you want to contact the DB
        if (conn.openConnection()){
            //the query to get a single subscription
            String query = "SELECT * FROM Languages WHERE id = "+id;

            //the result from the query after querying
            ResultSet result = conn.executeSQLSelectStatement(query);
            try{
                //create a subscription with the result
                Language language = Language.valueOf(result.getString("languageCode"));

                //always close the connection when you're done with your query
                conn.closeConnection();

                //send the subscription back
                return language;
            }catch (SQLException e){
                //if something went wrong, it shows here
                System.out.println(e);
            }

        }

        return null;
    }

    @Override
    public List<Language> getAll() {
        List<Language> languages = new ArrayList<>();

        if (conn.openConnection()){
            String query = "SELECT * FROM Languages";

            ResultSet result = conn.executeSQLSelectStatement(query);
            try{

                while(result.next()) {
                    Language language = Language.valueOf(result.getString("languageCode"));

                    languages.add(language);
                }

                conn.closeConnection();

                return languages;
            }catch (SQLException e){
                System.out.println(e);
            }

        }

        return null;
    }

    @Override
    public boolean insert(Language language) {
        return false;
    }

    @Override
    public boolean update(Language language) {
        return false;
    }

    @Override
    public boolean delete(Language language) {
        return false;
    }
}
