import presentation.UserInterface;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Load in the UI
        UserInterface ui = new UserInterface();
        SwingUtilities.invokeLater(ui);

    }
}
