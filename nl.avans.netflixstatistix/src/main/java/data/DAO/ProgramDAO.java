package main.java.data.DAO;

import main.java.data.Program;
import main.java.data.connection.SQLConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProgramDAO implements DAO<Program> {

    SQLConnection sqlConnection;

    public ProgramDAO(SQLConnection sqlConnection) {
        this.sqlConnection = sqlConnection;
    }

    @Override
    public Program get(int id) throws SQLException {
        ResultSet rsProgram = sqlConnection.executeSQLSelectStatement("SELECT * FROM Program WHERE ProgramID = " + String.valueOf(id));

        List<List<String>> rowsProgram = sqlConnection.formatResultSet(rsProgram);

        for (List<String> row : rowsProgram) {
            return new Program(Integer.valueOf(row.get(0)), row.get(1), row.get(2), row.get(3), row.get(4), Integer.valueOf(row.get(5)));
        }

        return null;
    }

    @Override
    public List<Program> getAll() throws SQLException {
        List<Program> programs = new ArrayList<Program>();

        ResultSet rsProgram = sqlConnection.executeSQLSelectStatement("SELECT * FROM Program");

        List<List<String>> rowsProgram = sqlConnection.formatResultSet(rsProgram);

        for (List<String> row : rowsProgram) {
            programs.add(new Program(Integer.valueOf(row.get(0)), row.get(1), row.get(2), row.get(3), row.get(4), Integer.valueOf(row.get(5))));
        }

        return programs;
    }

    @Override
    public int insert(Program program) throws SQLException {
        ResultSet rsProgram = sqlConnection.executeSQLInsertStatement("INSERT INTO Program (Titel, Genre, Language, ShortDescription, MinAge) VALUES ('" + program.getTitle() + "', '" + program.getGenre() + "', '" + program.getLanguage() + "', '" + program.getShortDescription() + "', " + program.getMinAge() + ")");

        if (rsProgram != null) {
            int programID = sqlConnection.resultSetKey(rsProgram);

            return programID;
        }

        return 0;
    }

    @Override
    public boolean update(Program program) {
        if (sqlConnection.executeSQLDeleteStatement("UPDATE Program SET Titel = '" + program.getTitle() + "', Genre = '" + program.getGenre() + "', Language = '" + program.getLanguage() + "', ShortDescription = '" + program.getShortDescription() + "', MinAge = '" + program.getMinAge() + "' WHERE ProgramID = " + program.getProgramID())) {
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(Program program) {
        if (sqlConnection.executeSQLDeleteStatement("DELETE FROM Program WHERE ProgramID = " + program.getProgramID())) {
            return true;
        }

        return false;
    }
}
