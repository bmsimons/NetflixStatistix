package main.java.data;

import main.java.data.connection.SQLConnection;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DataModel {
    private List<Program> programs;
    private List<Film> films;
    private List<Serie> series;
    private List<Season> seasons;
    private List<Episode> episodes;

    private SQLConnection sqlConnection;

    public List<List<String>> formatResultSet(ResultSet rs) throws SQLException {
        final ResultSetMetaData meta = rs.getMetaData();
        final int columnCount = meta.getColumnCount();
        final List<List<String>> rowList = new LinkedList<List<String>>();
        while (rs.next()) {
            final List<String> columnList = new LinkedList<String>();
            rowList.add(columnList);

            for (int column = 1; column <= columnCount; ++column) {
                final Object value = rs.getObject(column);
                columnList.add(String.valueOf(value));
            }
        }

        return rowList;
    }

    public void tableToModel(Table table) throws SQLException {
        switch (table) {
            case PROGRAM:
                ResultSet rsProgram = sqlConnection.executeSQLSelectStatement("SELECT * FROM Program");

                List<List<String>> rowsProgram = formatResultSet(rsProgram);

                for (List<String> row : rowsProgram) {
                    programs.add(new Program(Integer.valueOf(row.get(0)), row.get(1), row.get(2), row.get(3), row.get(4), Integer.valueOf(row.get(5))));
                }

                break;
            case FILM:
                ResultSet rsFilm = sqlConnection.executeSQLSelectStatement("SELECT * FROM Film");

                List<List<String>> rowsFilm = formatResultSet(rsFilm);

                for (List<String> row : rowsFilm) {
                    films.add(new Film(Integer.valueOf(row.get(0)), Integer.valueOf(row.get(1)), Integer.valueOf(row.get(2))));
                }
            case SERIE:
                ResultSet rsSerie = sqlConnection.executeSQLSelectStatement("SELECT * FROM Film");

                List<List<String>> rowsSerie = formatResultSet(rsSerie);

                for (List<String> row : rowsSerie) {
                    series.add(new Serie(Integer.valueOf(row.get(0)), Integer.valueOf(row.get(1))));
                }
            case SEASON:
                ResultSet rsSeason = sqlConnection.executeSQLSelectStatement("SELECT * FROM Film");

                List<List<String>> rowsSeason = formatResultSet(rsSeason);

                for (List<String> row : rowsSeason) {
                    seasons.add(new Season(Integer.valueOf(row.get(0)), Integer.valueOf(row.get(1)), Integer.valueOf(row.get(2))));
                }
            case EPISODE:
                ResultSet rsEpisode = sqlConnection.executeSQLSelectStatement("SELECT * FROM Film");

                List<List<String>> rowsEpisode = formatResultSet(rsEpisode);

                for (List<String> row : rowsEpisode) {
                    episodes.add(new Episode(Integer.valueOf(row.get(0)), Integer.valueOf(row.get(1)), row.get(2), Integer.valueOf(row.get(3)), Integer.valueOf(row.get(4))));
                }
        }
    }

    public DataModel() throws SQLException {
        programs = new ArrayList<Program>();
        films = new ArrayList<Film>();
        series = new ArrayList<Serie>();
        seasons = new ArrayList<Season>();
        episodes = new ArrayList<Episode>();

        sqlConnection = new SQLConnection();

        if (!sqlConnection.openConnection()) {
            throw new SQLException("Connection can't be opened. :(");
        }

        for (Table table : Table.values()) {
            tableToModel(table);
        }

        for (Program program : programs) {
            System.out.println(program.getProgramID());
        }
    }
}
