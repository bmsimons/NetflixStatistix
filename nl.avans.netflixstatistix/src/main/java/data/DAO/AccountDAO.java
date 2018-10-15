package main.java.data.DAO;

import main.java.data.Account;
import main.java.data.connection.SQLConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO implements DAO<Account> {
    SQLConnection sqlConnection;

    public AccountDAO(SQLConnection sqlConnection) {
        this.sqlConnection = sqlConnection;
    }


    @Override
    public Account get(int id) throws SQLException {
        ResultSet rsAccount = sqlConnection.executeSQLSelectStatement("SELECT * FROM Account WHERE SubscriptionID = " + String.valueOf(id));

        List<List<String>> rowsAccount = sqlConnection.formatResultSet(rsAccount);

        for (List<String> row : rowsAccount) {
            return new Account(Integer.valueOf(row.get(0)), row.get(1), row.get(2), row.get(3), row.get(4), row.get(5), Integer.valueOf(row.get(6)), row.get(7));
        }

        return null;
    }

    @Override
    public List<Account> getAll() throws SQLException {
        List<Account> accounts = new ArrayList<Account>();

        ResultSet rsAccount = sqlConnection.executeSQLSelectStatement("SELECT * FROM Account");

        List<List<String>> rowsAccount = sqlConnection.formatResultSet(rsAccount);

        for (List<String> row : rowsAccount) {
            accounts.add(new Account(Integer.valueOf(row.get(0)), row.get(1), row.get(2), row.get(3), row.get(4), row.get(5), Integer.valueOf(row.get(6)), row.get(7)));
        }

        return null;
    }

    @Override
    public int insert(Account account) throws SQLException {
        ResultSet rsAccount = sqlConnection.executeSQLInsertStatement("INSERT INTO Account (Name, Email, Password, Street, Postcode, HouseNumber, City) VALUES ('" + account.getName() + "', '" + account.getEmail() + "', '" + account.getPassword() + "', '" + account.getStreet() + "', '" + account.getPostcode() + "', " + account.getHouseNumber() + ", '" + account.getCity() + "')");

        if (rsAccount != null) {
            int subscriptionID = sqlConnection.resultSetKey(rsAccount);

            return subscriptionID;
        }

        return 0;
    }

    @Override
    public boolean update(Account account) {
        if (sqlConnection.executeSQLDeleteStatement("UPDATE Account SET Name = '" + account.getName() + "', Email = '" + account.getEmail() + "', Password = '" + account.getPassword() + "', Street = '" + account.getStreet() + "', Postcode = '" + account.getPostcode() + "', HouseNumber = " + account.getHouseNumber() + ", City = '" + account.getCity() + "' WHERE SubscriptionID = " + account.getSubscriptionID())) {
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(Account account) {
        if (sqlConnection.executeSQLDeleteStatement("DELETE FROM Account WHERE SubscriptionID = " + account.getSubscriptionID())) {
            return true;
        }

        return false;
    }
}
