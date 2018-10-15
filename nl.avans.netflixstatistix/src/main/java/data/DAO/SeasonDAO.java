package main.java.data.DAO;

import main.java.data.Season;
import main.java.data.connection.SQLConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SeasonDAO implements DAO<Season> {

    SQLConnection sqlConnection;

    public SeasonDAO(SQLConnection sqlConnection) {
        this.sqlConnection = sqlConnection;
    }

    @Override
    public Season get(int id) throws SQLException {
        ResultSet rsSeason = sqlConnection.executeSQLSelectStatement("SELECT * FROM Season WHERE SeasonID = " + String.valueOf(id));

        List<List<String>> rowsSeason = sqlConnection.formatResultSet(rsSeason);

        for (List<String> row : rowsSeason) {
            return new Season(Integer.valueOf(row.get(0)), Integer.valueOf(row.get(1)), Integer.valueOf(row.get(2)));
        }

        return null;
    }

    @Override
    public List<Season> getAll() throws SQLException {
        List<Season> seasons = new ArrayList<Season>();

        ResultSet rsSeason = sqlConnection.executeSQLSelectStatement("SELECT * FROM Season");

        List<List<String>> rowsSeason = sqlConnection.formatResultSet(rsSeason);

        for (List<String> row : rowsSeason) {
            seasons.add(new Season(Integer.valueOf(row.get(0)), Integer.valueOf(row.get(1)), Integer.valueOf(row.get(2))));
        }

        return seasons;
    }

    @Override
    public int insert(Season season) throws SQLException {
        ResultSet rsSeason = sqlConnection.executeSQLInsertStatement("INSERT INTO Season (SerieID, SeasonNumber) VALUES ('" + season.getSerieID() + "', '" + season.getSeasonNumber() + "')");

        if (rsSeason != null) {
            int seasonID = sqlConnection.resultSetKey(rsSeason);

            return seasonID;
        }

        return 0;
    }

    @Override
    public boolean update(Season season) {
        if (sqlConnection.executeSQLDeleteStatement("UPDATE Season SET SerieID = " + season.getSerieID() + ", SeasonNumber = " + season.getSeasonNumber() + " WHERE SeasonID = " + season.getSeasonID())) {
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(Season season) {
        if (sqlConnection.executeSQLDeleteStatement("DELETE FROM Season WHERE SeasonID = " + season.getSeasonID())) {
            return true;
        }

        return false;
    }
}
