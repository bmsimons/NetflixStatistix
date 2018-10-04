package main.java;

import main.java.data.DataModel;
import main.java.data.connection.SQLConnection;
import main.java.presentation.view.UserInterface;

import javax.swing.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();

        SwingUtilities.invokeLater(ui);

        try {
            DataModel dataModel = new DataModel();
            dataModel.newProgram("AAAA", "Drama", "NL", "iets", 12);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
