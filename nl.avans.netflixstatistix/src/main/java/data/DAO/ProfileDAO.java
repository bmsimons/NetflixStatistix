package main.java.data.DAO;

import main.java.data.Profile;
import main.java.data.connection.SQLConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ProfileDAO implements DAO<Profile> {
    SQLConnection sqlConnection;

    public ProfileDAO(SQLConnection sqlConnection) {
        this.sqlConnection = sqlConnection;
    }


    @Override
    public Profile get(int id) throws SQLException {
        ResultSet rsProfile = sqlConnection.executeSQLSelectStatement("SELECT * FROM Profile WHERE ProfileID = " + String.valueOf(id));

        List<List<String>> rowsProfile = sqlConnection.formatResultSet(rsProfile);

        for (List<String> row : rowsProfile) {
            try {
                return new Profile(Integer.valueOf(row.get(0)), Integer.valueOf(row.get(1)), (new SimpleDateFormat("dd/MM/yyyy")).parse(row.get(2)));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public List<Profile> getAll() throws SQLException {
        List<Profile> profiles = new ArrayList<Profile>();

        ResultSet rsProfile = sqlConnection.executeSQLSelectStatement("SELECT * FROM Profile");

        List<List<String>> rowsProfile = sqlConnection.formatResultSet(rsProfile);

        for (List<String> row : rowsProfile) {
            try {
                profiles.add(new Profile(Integer.valueOf(row.get(0)), Integer.valueOf(row.get(1)), (new SimpleDateFormat("dd/MM/yyyy")).parse(row.get(2))));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return profiles;
    }

    @Override
    public int insert(Profile profile) throws SQLException {
        ResultSet rsProfile = sqlConnection.executeSQLInsertStatement("INSERT INTO Profile (SubscriptionID, BirthDate) VALUES (" + profile.getSubscriptionID() + ", " + profile.getBirthDate() + ")");

        if (rsProfile != null) {
            int profileID = sqlConnection.resultSetKey(rsProfile);

            return profileID;
        }

        return 0;
    }

    @Override
    public boolean update(Profile profile) {
        if (sqlConnection.executeSQLDeleteStatement("UPDATE Profile SET SubscriptionID = " + profile.getSubscriptionID() + ", BirthDate = " + profile.getBirthDate())) {
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(Profile profile) {
        if (sqlConnection.executeSQLDeleteStatement("DELETE FROM Profile WHERE ProfileID = " + profile.getProfileID())) {
            return true;
        }

        return false;
    }
}
