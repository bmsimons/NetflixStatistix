import data.DataModel;
import data.Table;
import presentation.UserInterface;

import javax.swing.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();

        SwingUtilities.invokeLater(ui);

        try {
            DataModel dataModel = new DataModel();
            // dataModel.newProgram("AAAA", "Drama", "NL", "iets", 12);
            // dataModel.newFilm(12, 60);
            // dataModel.removeFilm(2);

            dataModel.removeFilm(dataModel.getFromTable(Table.FILM, 2));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
