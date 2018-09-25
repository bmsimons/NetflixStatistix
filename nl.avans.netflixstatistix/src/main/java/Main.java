package main.java;

import main.java.presentation.view.UserInterface;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();

        SwingUtilities.invokeLater(ui);
    }
}
