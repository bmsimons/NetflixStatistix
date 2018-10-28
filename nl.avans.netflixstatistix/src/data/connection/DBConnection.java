package data.connection;

import java.sql.*;

public class DBConnection {

    private Connection connection;

    private Statement statement;

    public DBConnection()
    {
        connection = null;
        statement = null;
    }

    // Used for starting the connection with the database
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

    // Used to check if the connection is open
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

    // Used to close the connection with the database
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

    // Used to execute insert queries
    public boolean executeSQLInsertStatement(String query)
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

    // Used to execute delete queries
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

    // returns current connection
    public Connection getConnection(){
        return this.connection;
    }
}