package main.java.data.DAO;

import main.java.data.Episode;
import main.java.data.connection.SQLConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EpisodeDAO implements DAO<Episode> {

    SQLConnection sqlConnection;

    public EpisodeDAO(SQLConnection sqlConnection) {
        this.sqlConnection = sqlConnection;
    }

    @Override
    public Episode get(int id) throws SQLException {
        ResultSet rsEpisode = sqlConnection.executeSQLSelectStatement("SELECT * FROM Episode WHERE EpisodeID = " + String.valueOf(id));

        List<List<String>> rowsEpisode = sqlConnection.formatResultSet(rsEpisode);

        for (List<String> row : rowsEpisode) {
            return new Episode(Integer.valueOf(row.get(0)), Integer.valueOf(row.get(1)), Integer.valueOf(row.get(2)), row.get(3), Integer.valueOf(row.get(4)));
        }

        return null;
    }

    @Override
    public List<Episode> getAll() throws SQLException {
        List<Episode> episodes = new ArrayList<Episode>();

        ResultSet rsEpisode = sqlConnection.executeSQLSelectStatement("SELECT * FROM Episode");

        List<List<String>> rowsEpisode = sqlConnection.formatResultSet(rsEpisode);

        for (List<String> row : rowsEpisode) {
            episodes.add(new Episode(Integer.valueOf(row.get(0)), Integer.valueOf(row.get(1)), Integer.valueOf(row.get(2)), row.get(3), Integer.valueOf(row.get(4))));
        }

        return episodes;
    }

    @Override
    public int insert(Episode episode) throws SQLException {
        ResultSet rsEpisode = sqlConnection.executeSQLInsertStatement("INSERT INTO Episode (SerieID, SeasonID, ShortDescription, EpisodeNumber) VALUES (" + episode.getSerieID() + ", " + episode.getSeasonID() + ", '" + episode.getShortDescription() + "', " + episode.getEpisodeNumber() + ")");

        if (rsEpisode != null) {
            int episodeID = sqlConnection.resultSetKey(rsEpisode);

            return episodeID;
        }

        return 0;
    }

    @Override
    public boolean update(Episode episode) {
        if (sqlConnection.executeSQLDeleteStatement("UPDATE Episode SET SerieID = " + episode.getSerieID() + ", SeasonID = " + episode.getSeasonID() + ", ShortDescription = '" + episode.getShortDescription() + "', EpisodeNumber = " + episode.getEpisodeNumber())) {
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(Episode episode) {
        if (sqlConnection.executeSQLDeleteStatement("DELETE FROM Episode WHERE EpisodeID = " + episode.getEpisodeID())) {
            return true;
        }

        return false;
    }
}
