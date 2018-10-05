package main.java.data;

import main.java.data.connection.SQLConnection;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DataModel {
    private List<ITable> programs;
    private List<ITable> films;
    private List<ITable> series;
    private List<ITable> seasons;
    private List<ITable> episodes;
    private List<ITable> accounts;
    private List<ITable> profiles;

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

    public int resultSetKey(ResultSet rs) throws SQLException {
        Integer id = null;

        if (rs.next()) {
            id = rs.getInt(0);
        }

        return id;
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

                break;
            case SERIE:
                ResultSet rsSerie = sqlConnection.executeSQLSelectStatement("SELECT * FROM Serie");

                List<List<String>> rowsSerie = formatResultSet(rsSerie);

                for (List<String> row : rowsSerie) {
                    series.add(new Serie(Integer.valueOf(row.get(0)), Integer.valueOf(row.get(1))));
                }

                break;
            case SEASON:
                ResultSet rsSeason = sqlConnection.executeSQLSelectStatement("SELECT * FROM Season");

                List<List<String>> rowsSeason = formatResultSet(rsSeason);

                for (List<String> row : rowsSeason) {
                    seasons.add(new Season(Integer.valueOf(row.get(0)), Integer.valueOf(row.get(1)), Integer.valueOf(row.get(2))));
                }

                break;
            case EPISODE:
                ResultSet rsEpisode = sqlConnection.executeSQLSelectStatement("SELECT * FROM Episode");

                List<List<String>> rowsEpisode = formatResultSet(rsEpisode);

                for (List<String> row : rowsEpisode) {
                    episodes.add(new Episode(Integer.valueOf(row.get(0)), Integer.valueOf(row.get(1)), Integer.valueOf(row.get(2)), row.get(3), Integer.valueOf(row.get(4))));
                }

                break;
        }
    }

    public ITable getFromTable(Table table, int id) throws SQLException {
        switch (table) {
            case PROGRAM:
                ResultSet rsProgram = sqlConnection.executeSQLSelectStatement("SELECT * FROM Program WHERE ProgramID = " + String.valueOf(id));

                List<List<String>> rowsProgram = formatResultSet(rsProgram);

                for (List<String> row : rowsProgram) {
                    return new Program(Integer.valueOf(row.get(0)), row.get(1), row.get(2), row.get(3), row.get(4), Integer.valueOf(row.get(5)));
                }

                break;
            case FILM:
                ResultSet rsFilm = sqlConnection.executeSQLSelectStatement("SELECT * FROM Film WHERE FilmID = " + String.valueOf(id));

                List<List<String>> rowsFilm = formatResultSet(rsFilm);

                for (List<String> row : rowsFilm) {
                    return new Film(Integer.valueOf(row.get(0)), Integer.valueOf(row.get(1)), Integer.valueOf(row.get(2)));
                }

                break;
            case SERIE:
                ResultSet rsSerie = sqlConnection.executeSQLSelectStatement("SELECT * FROM Serie WHERE SerieID = " + String.valueOf(id));

                List<List<String>> rowsSerie = formatResultSet(rsSerie);

                for (List<String> row : rowsSerie) {
                    return new Serie(Integer.valueOf(row.get(0)), Integer.valueOf(row.get(1)));
                }

                break;
            case SEASON:
                ResultSet rsSeason = sqlConnection.executeSQLSelectStatement("SELECT * FROM Season WHERE SeasonID = " + String.valueOf(id));

                List<List<String>> rowsSeason = formatResultSet(rsSeason);

                for (List<String> row : rowsSeason) {
                    return new Season(Integer.valueOf(row.get(0)), Integer.valueOf(row.get(1)), Integer.valueOf(row.get(2)));
                }

                break;
            case EPISODE:
                ResultSet rsEpisode = sqlConnection.executeSQLSelectStatement("SELECT * FROM Episode WHERE EpisodeID = " + String.valueOf(id));

                List<List<String>> rowsEpisode = formatResultSet(rsEpisode);

                for (List<String> row : rowsEpisode) {
                    return new Episode(Integer.valueOf(row.get(0)), Integer.valueOf(row.get(1)), Integer.valueOf(row.get(2)), row.get(3), Integer.valueOf(row.get(4)));
                }

                break;
        }

        return null;
    }

    public void addToTable(Table table, ITable object) throws SQLException {
        switch (table) {
            case PROGRAM:
                Program program = (Program) object;

                ResultSet rsProgram = sqlConnection.executeSQLInsertStatement("INSERT INTO Program (Titel, Genre, Language, ShortDescription, MinAge) VALUES ('" + program.getTitle() + "', '" + program.getGenre() + "', '" + program.getLanguage() + "', '" + program.getShortDescription() + "', " + program.getMinAge() + ")");

                if (rsProgram != null) {
                    int programID = resultSetKey(rsProgram);

                    program.setProgramID(programID);

                    programs.add(program);
                }

                break;
            case FILM:
                Film film = (Film) object;

                ResultSet rsFilm = sqlConnection.executeSQLInsertStatement("INSERT INTO Film (ProgramID, Duration) VALUES (" + film.getProgramID() + ", " + film.getDuration() + ")");

                if (rsFilm != null) {
                    int filmID = resultSetKey(rsFilm);

                    film.setFilmID(filmID);

                    films.add(film);
                }

                break;
            case SERIE:
                Serie serie = (Serie) object;

                ResultSet rsSerie = sqlConnection.executeSQLInsertStatement("INSERT INTO Serie (ProgramID) VALUES (" + serie.getProgramID() + ")");

                if (rsSerie != null) {
                    int serieID = resultSetKey(rsSerie);

                    serie.setSerieID(serieID);

                    series.add(serie);
                }

                break;
            case SEASON:
                Season season = (Season) object;

                ResultSet rsSeason = sqlConnection.executeSQLInsertStatement("INSERT INTO Season (SerieID, SeasonNumber) VALUES ('" + season.getSerieID() + "', '" + season.getSeasonNumber() + "')");

                if (rsSeason != null) {
                    int seasonID = resultSetKey(rsSeason);

                    season.setSeasonID(seasonID);

                    seasons.add(season);
                }

                break;
            case EPISODE:
                Episode episode = (Episode) object;

                ResultSet rsEpisode = sqlConnection.executeSQLInsertStatement("INSERT INTO Episode (SerieID, SeasonID, ShortDescription, EpisodeNumber) VALUES (" + episode.getSerieID() + ", " + episode.getSeasonID() + ", '" + episode.getShortDescription() + "', " + episode.getEpisodeNumber() + ")");

                if (rsEpisode != null) {
                    int episodeID = resultSetKey(rsEpisode);

                    episode.setEpisodeID(episodeID);

                    episodes.add(episode);
                }

                break;
        }
    }

    public void removeFromTable(Table table, ITable object) {
        switch (table) {
            case PROGRAM:
                Program program = (Program) object;

                if (sqlConnection.executeSQLDeleteStatement("DELETE FROM Program WHERE ProgramID = " + program.getProgramID())) {
                    programs.remove(program);
                }

                break;
            case FILM:
                Film film = (Film) object;

                if (sqlConnection.executeSQLDeleteStatement("DELETE FROM Film WHERE FilmID = " + film.getFilmID())) {
                    films.remove(film);
                }

                break;
            case SERIE:
                Serie serie = (Serie) object;

                if (sqlConnection.executeSQLDeleteStatement("DELETE FROM Serie WHERE SerieID = " + serie.getSerieID())) {
                    series.remove(serie);
                }

                break;
            case SEASON:
                Season season = (Season) object;

                if (sqlConnection.executeSQLDeleteStatement("DELETE FROM Season WHERE SeasonID = " + season.getSeasonID())) {
                    seasons.remove(season);
                }

                break;
            case EPISODE:
                Episode episode = (Episode) object;

                if (sqlConnection.executeSQLDeleteStatement("DELETE FROM Episode WHERE EpisodeID = " + episode.getEpisodeID())) {
                    episodes.remove(episode);
                }

                break;
            case ACCOUNT:
                Account account = (Account) object;

                if (sqlConnection.executeSQLDeleteStatement("DELETE FROM Account WHERE SubscriptionID = " + account.getSubscriptionID())) {
                    accounts.remove(account);
                }

                break;
            case PROFILE:
                Profile profile = (Profile) object;

                if (sqlConnection.executeSQLDeleteStatement("DELETE FROM Profile WHERE ProfileID = " + profile.getProfileID())) {
                    profiles.remove(profile);
                }
        }
    }

    public void updateTable(Table table, ITable object) {
        switch (table) {
            case PROGRAM:
                Program program = (Program) object;
            case FILM:
                Film film = (Film) object;
            case SERIE:
                Serie serie = (Serie) object;
            case SEASON:
                Season season = (Season) object;
            case EPISODE:
                Episode episode = (Episode) object;
        }
    }

    public DataModel() throws SQLException {
        programs = new ArrayList<ITable>();
        films = new ArrayList<ITable>();
        series = new ArrayList<ITable>();
        seasons = new ArrayList<ITable>();
        episodes = new ArrayList<ITable>();
        accounts = new ArrayList<ITable>();
        profiles = new ArrayList<ITable>();

        sqlConnection = new SQLConnection();

        if (!sqlConnection.openConnection()) {
            throw new SQLException("Connection can't be opened. :(");
        }

        for (Table table : Table.values()) {
            tableToModel(table);
        }
    }

    public void newProgram(String title, String genre, String language, String shortDescription, int minAge) throws SQLException {
        Program program = new Program(0, title, genre, language, shortDescription, minAge);

        addToTable(Table.PROGRAM, program);
    }

    public void newFilm(int programID, int duration) throws SQLException {
        Film film = new Film(0, programID, duration);

        addToTable(Table.FILM, film);
    }

    public void newSerie(int programID) throws SQLException {
        Serie serie = new Serie(0, programID);

        addToTable(Table.SERIE, serie);
    }

    public void newSeason(int serieID, int seasonNumber) throws SQLException {
        Season season = new Season(0, serieID, seasonNumber);

        addToTable(Table.SEASON, season);
    }

    public void newEpisode(int serieID, int seasonID, String shortDescription, int episodeNumber) throws SQLException {
        Episode episode = new Episode(0, serieID, seasonID, shortDescription, episodeNumber);

        addToTable(Table.EPISODE, episode);
    }

    public void removeProgram(ITable program) throws SQLException {
        removeFromTable(Table.PROGRAM, program);
    }

    public void removeFilm(ITable film) throws SQLException {
        removeFromTable(Table.FILM, film);
    }

    public void removeSerie(ITable serie) throws SQLException {
        removeFromTable(Table.SERIE, serie);
    }

    public void removeSeason(ITable season) throws SQLException {
        removeFromTable(Table.SEASON, season);
    }

    public void removeEpisode(ITable episode) throws SQLException {
        removeFromTable(Table.EPISODE, episode);
    }
}
