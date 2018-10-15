package main.java.data.DAO;

import main.java.data.Film;
import main.java.data.connection.SQLConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmDAO implements DAO<Film> {

    SQLConnection sqlConnection;

    public FilmDAO(SQLConnection sqlConnection) { this.sqlConnection = sqlConnection; }

    @Override
    public Film get(int id) throws SQLException {
        ResultSet rsFilm = sqlConnection.executeSQLSelectStatement("SELECT * FROM Film WHERE FilmID = " + String.valueOf(id));

        List<List<String>> rowsFilm = sqlConnection.formatResultSet(rsFilm);

        for (List<String> row : rowsFilm) {
            return new Film(Integer.valueOf(row.get(0)), Integer.valueOf(row.get(1)), Integer.valueOf(row.get(2)));
        }

        return null;
    }

    @Override
    public List<Film> getAll() throws SQLException {
        List<Film> films = new ArrayList<Film>();

        ResultSet rsFilm = sqlConnection.executeSQLSelectStatement("SELECT * FROM Film");

        List<List<String>> rowsFilm = sqlConnection.formatResultSet(rsFilm);

        for (List<String> row : rowsFilm) {
            films.add(new Film(Integer.valueOf(row.get(0)), Integer.valueOf(row.get(1)), Integer.valueOf(row.get(2))));
        }

        return films;
    }

    @Override
    public int insert(Film film) throws SQLException {
        ResultSet rsFilm = sqlConnection.executeSQLInsertStatement("INSERT INTO Film (ProgramID, Duration) VALUES (" + film.getProgramID() + ", " + film.getDuration() + ")");

        if (rsFilm != null) {
            int filmID = sqlConnection.resultSetKey(rsFilm);

            return filmID;
        }

        return 0;
    }

    @Override
    public boolean update(Film film) {
        if (sqlConnection.executeSQLDeleteStatement("UPDATE Film SET ProgramID = " + film.getProgramID() + ", Duration = " + film.getDuration() + " WHERE FilmID = " + film.getFilmID())) {
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(Film film) {
        if (sqlConnection.executeSQLDeleteStatement("DELETE FROM Film WHERE FilmID = " + film.getFilmID())) {
            return true;
        }

        return false;
    }
}
