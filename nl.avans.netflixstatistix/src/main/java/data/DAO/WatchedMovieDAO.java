package main.java.data.DAO;

import main.java.data.WatchedMovie;
import main.java.data.connection.SQLConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WatchedMovieDAO implements DAO<WatchedMovie> {
    SQLConnection sqlConnection;

    public WatchedMovieDAO(SQLConnection sqlConnection) {
        this.sqlConnection = sqlConnection;
    }


    @Override
    public WatchedMovie get(int id) throws SQLException {
        ResultSet rsWatchedMovie = sqlConnection.executeSQLSelectStatement("SELECT * FROM WatchedMovies WHERE WatchedMovieID = " + String.valueOf(id));

        List<List<String>> rowsWatchedMovie = sqlConnection.formatResultSet(rsWatchedMovie);

        for (List<String> row : rowsWatchedMovie) {
            return new WatchedMovie(Integer.valueOf(row.get(0)), Integer.valueOf(row.get(1)), Integer.valueOf(row.get(2)));
        }

        return null;
    }

    @Override
    public List<WatchedMovie> getAll() throws SQLException {
        List<WatchedMovie> watchedMovies = new ArrayList<WatchedMovie>();

        ResultSet rsWatchedMovie = sqlConnection.executeSQLSelectStatement("SELECT * FROM WatchedMovies");

        List<List<String>> rowsWatchedMovie = sqlConnection.formatResultSet(rsWatchedMovie);

        for (List<String> row : rowsWatchedMovie) {
            watchedMovies.add(new WatchedMovie(Integer.valueOf(row.get(0)), Integer.valueOf(row.get(1)), Integer.valueOf(row.get(2))));
        }

        return watchedMovies;
    }

    @Override
    public int insert(WatchedMovie watchedMovie) throws SQLException {
        ResultSet rsWatchedMovie = sqlConnection.executeSQLInsertStatement("INSERT INTO WatchedMovies (WatchedMovieID, ProfileID, FilmID) VALUES (" + watchedMovie.getWatchedMovieID() + ", " + watchedMovie.getProfileID() + ", " + watchedMovie.getFilmID() + ")");

        if (rsWatchedMovie != null) {
            int watchedMovieID = sqlConnection.resultSetKey(rsWatchedMovie);

            return watchedMovieID;
        }

        return 0;
    }

    @Override
    public boolean update(WatchedMovie watchedMovie) {
        if (sqlConnection.executeSQLDeleteStatement("UPDATE WatchedMovies SET WatchedMovieID = " + watchedMovie.getWatchedMovieID() + ", ProfileID = " + watchedMovie.getProfileID() + ", FilmID = " + watchedMovie.getFilmID())) {
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(WatchedMovie watchedMovie) {
        if (sqlConnection.executeSQLDeleteStatement("DELETE FROM WatchedMovies WHERE WatchedMovieID = " + watchedMovie.getWatchedMovieID())) {
            return true;
        }

        return false;
    }
}
