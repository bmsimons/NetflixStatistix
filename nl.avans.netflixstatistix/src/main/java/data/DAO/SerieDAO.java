package main.java.data.DAO;

import main.java.data.Serie;
import main.java.data.connection.SQLConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SerieDAO implements DAO<Serie> {

    SQLConnection sqlConnection;

    public SerieDAO(SQLConnection sqlConnection) {
        this.sqlConnection = sqlConnection;
    }

    @Override
    public Serie get(int id) throws SQLException {
        ResultSet rsSerie = sqlConnection.executeSQLSelectStatement("SELECT * FROM Serie WHERE SerieID = " + String.valueOf(id));

        List<List<String>> rowsSerie = sqlConnection.formatResultSet(rsSerie);

        for (List<String> row : rowsSerie) {
            return new Serie(Integer.valueOf(row.get(0)), Integer.valueOf(row.get(1)));
        }

        return null;
    }

    @Override
    public List<Serie> getAll() throws SQLException {
        List<Serie> series = new ArrayList<Serie>();

        ResultSet rsSerie = sqlConnection.executeSQLSelectStatement("SELECT * FROM Serie");

        List<List<String>> rowsSerie = sqlConnection.formatResultSet(rsSerie);

        for (List<String> row : rowsSerie) {
            series.add(new Serie(Integer.valueOf(row.get(0)), Integer.valueOf(row.get(1))));
        }

        return null;
    }

    @Override
    public int insert(Serie serie) throws SQLException {
        ResultSet rsSerie = sqlConnection.executeSQLInsertStatement("INSERT INTO Serie (ProgramID) VALUES (" + serie.getProgramID() + ")");

        if (rsSerie != null) {
            int serieID = sqlConnection.resultSetKey(rsSerie);

            return serieID;
        }

        return 0;
    }

    @Override
    public boolean update(Serie serie) {
        if (sqlConnection.executeSQLDeleteStatement("UPDATE Serie SET ProgramID = " + serie.getProgramID() + " WHERE SerieID = " + serie.getSerieID())) {
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(Serie serie) {
        if (sqlConnection.executeSQLDeleteStatement("DELETE FROM Serie WHERE SerieID = " + serie.getSerieID())) {
            return true;
        }

        return false;
    }
}
