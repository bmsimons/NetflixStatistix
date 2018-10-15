package main.java.presentation.view;

import javax.swing.*;
import java.awt.*;

public class UserInterface implements Runnable, UI {

    private JFrame frame;
    @Override
    public void run() {
        frame = new JFrame("Netflix Statistix");
        frame.setLayout(new BorderLayout());

        frame.setPreferredSize(new Dimension(800, 500));

        // TODO: Set a proper minimum size
        frame.setMinimumSize(frame.getPreferredSize());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void createComponents(Container container) {
        container.setSize(frame.getWidth(), frame.getHeight());
        // Add items to the container
        //container.add(navigationPanel, BorderLayout.NORTH);
        container.add(new NavigationPanel(new Dimension(container.getWidth(), container.getHeight()-24)), BorderLayout.CENTER);
        //container.add(contentPanel, BorderLayout.CENTER);
        container.add(new FooterPanel(new Dimension(container.getWidth(), 24)), BorderLayout.SOUTH);
    }
}
