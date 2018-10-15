package main.java.data.connection;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author ppthgast, modified by @bmsimons
 */
public class SQLConnection {

    private Connection connection;

    // The Statement object has been defined as a field because some methods
    // may return a ResultSet object. If so, the statement object may not
    // be closed as you would do when it was a local variable in the query
    // execution method.
    private Statement statement;

    public SQLConnection()
    {
        connection = null;
        statement = null;
    }

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

    public boolean openConnection()
    {
        boolean result = false;

        if(connection == null)
        {
            try
            {
                // Try to create a connection with the library database
                connection = DriverManager.getConnection(
                        "jdbc:sqlserver://localhost:1433;"
                                + "database=NetflixStatistix;"
                                + "user=Bob;"
                                + "password=P@ssw0rd;"
                                + "encrypt=false;"
                                + "loginTimeout=5;"
                );

                if(connection != null)
                {
                    statement = connection.createStatement();
                }

                result = true;
            }
            catch(SQLException e)
            {
                System.out.println(e);
                result = false;
            }
        }
        else
        {
            // A connection was already initalized.
            result = true;
        }

        return result;
    }

    public boolean connectionIsOpen()
    {
        boolean open = false;

        if(connection != null && statement != null)
        {
            try
            {
                open = !connection.isClosed() && !statement.isClosed();
            }
            catch(SQLException e)
            {
                System.out.println(e);
                open = false;
            }
        }
        // Else, at least one the connection or statement fields is null, so
        // no valid connection.

        return open;
    }

    public void closeConnection()
    {
        try
        {
            statement.close();

            // Close the connection
            connection.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    public ResultSet executeSQLSelectStatement(String query)
    {
        ResultSet resultset = null;

        // First, check whether a some query was passed and the connection with
        // the database.
        if(query != null && connectionIsOpen())
        {
            // Then, if succeeded, execute the query.
            try
            {
                resultset = statement.executeQuery(query);
            }
            catch(SQLException e)
            {
                System.out.println(e);
                resultset = null;
            }
        }

        return resultset;
    }

    public ResultSet executeSQLInsertStatement(String query)
    {
        ResultSet resultset = null;

        // First, check whether a some query was passed and the connection with
        // the database.
        if(query != null && connectionIsOpen())
        {
            // Then, if succeeded, execute the query.
            try
            {
                Statement stmt = connection.createStatement();

                int affectedrows = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
                if (affectedrows != 0) {
                    resultset = stmt.getResultSet();
                }
            }
            catch(SQLException e)
            {
                e.printStackTrace();
                resultset = null;
            }
        }

        return resultset;
    }

    public boolean executeSQLDeleteStatement(String query)
    {
        boolean result = false;

        // First, check whether a some query was passed and the connection with
        // the database.
        if(query != null && connectionIsOpen())
        {
            // Then, if succeeded, execute the query.
            try
            {
                statement.executeUpdate(query);
                result = true;
            }
            catch(SQLException e)
            {
                System.out.println(e);
                result = false;
            }
        }

        return result;
    }
}