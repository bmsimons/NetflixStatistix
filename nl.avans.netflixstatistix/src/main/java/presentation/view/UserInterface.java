package main.java.presentation.view;

import javax.swing.*;
import java.awt.*;

public class UserInterface implements Runnable, UI {
    // Create the frame
    private JFrame frame;

    // Start setting up the frame
    @Override
    public void run() {
        frame = new JFrame("Netflix Statistix");
        frame.setLayout(new BorderLayout());

        frame.setPreferredSize(new Dimension(875, 500));

        // TODO: Set a proper minimum size
        frame.setMinimumSize(frame.getPreferredSize());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    // Create the components for the frame
    @Override
    public void createComponents(Container container) {
        container.setSize(frame.getWidth(), frame.getHeight());
        int footerHeight = 24;
        // Set the NavigationPanel width & height (Height = container height - footer height)
        container.add(new NavigationPanel(new Dimension(container.getWidth(), container.getHeight()-footerHeight)), BorderLayout.CENTER);
        container.add(new FooterPanel(new Dimension(container.getWidth(), footerHeight)), BorderLayout.SOUTH);
    }
}
