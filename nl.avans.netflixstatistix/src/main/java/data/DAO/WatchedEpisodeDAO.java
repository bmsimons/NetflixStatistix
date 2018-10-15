package main.java.data.DAO;

import main.java.data.WatchedEpisode;
import main.java.data.connection.SQLConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WatchedEpisodeDAO implements DAO<WatchedEpisode> {
    SQLConnection sqlConnection;

    public WatchedEpisodeDAO(SQLConnection sqlConnection) {
        this.sqlConnection = sqlConnection;
    }


    @Override
    public WatchedEpisode get(int id) throws SQLException {
        ResultSet rsWatchedEpisode = sqlConnection.executeSQLSelectStatement("SELECT * FROM WatchedEpisodes WHERE WatchedEpisodeID = " + String.valueOf(id));

        List<List<String>> rowsWatchedEpisode = sqlConnection.formatResultSet(rsWatchedEpisode);

        for (List<String> row : rowsWatchedEpisode) {
            return new WatchedEpisode(Integer.valueOf(row.get(0)), Integer.valueOf(row.get(1)), Integer.valueOf(row.get(2)));
        }

        return null;
    }

    @Override
    public List<WatchedEpisode> getAll() throws SQLException {
        List<WatchedEpisode> watchedEpisodes = new ArrayList<WatchedEpisode>();

        ResultSet rsWatchedEpisode = sqlConnection.executeSQLSelectStatement("SELECT * FROM WatchedEpisodes");

        List<List<String>> rowsWatchedEpisode = sqlConnection.formatResultSet(rsWatchedEpisode);

        for (List<String> row : rowsWatchedEpisode) {
            watchedEpisodes.add(new WatchedEpisode(Integer.valueOf(row.get(0)), Integer.valueOf(row.get(1)), Integer.valueOf(row.get(2))));
        }

        return watchedEpisodes;
    }

    @Override
    public int insert(WatchedEpisode watchedEpisode) throws SQLException {
        ResultSet rsWatchedEpisode = sqlConnection.executeSQLInsertStatement("INSERT INTO WatchedEpisodes (WatchedEpisodeID, ProfileID, EpisodeID) VALUES (" + watchedEpisode.getWatchedEpisodeID() + ", " + watchedEpisode.getProfileID() + ", " + watchedEpisode.getEpisodeID() + ")");

        if (rsWatchedEpisode != null) {
            int watchedEpisodeID = sqlConnection.resultSetKey(rsWatchedEpisode);

            return watchedEpisodeID;
        }

        return 0;
    }

    @Override
    public boolean update(WatchedEpisode watchedEpisode) {
        if (sqlConnection.executeSQLDeleteStatement("UPDATE WatchedEpisode SET WatchedEpisodeID = " + watchedEpisode.getWatchedEpisodeID() + ", ProfileID = " + watchedEpisode.getProfileID() + ", FilmID = " + watchedEpisode.getEpisodeID())) {
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(WatchedEpisode watchedEpisode) {
        if (sqlConnection.executeSQLDeleteStatement("UPDATE WatchedEpisode SET WatchedEpisodeID = " + watchedEpisode.getWatchedEpisodeID() + ", ProfileID = " + watchedEpisode.getProfileID() + ", FilmID = " + watchedEpisode.getEpisodeID())) {
            return true;
        }

        return false;
    }
}
