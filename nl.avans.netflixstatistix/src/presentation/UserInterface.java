package presentation;

import logic.ProgramManager;
import logic.SubscriptionManager;

import javax.swing.*;
import java.awt.*;

public class UserInterface implements Runnable, UI {
    // Create the frame
    private JFrame frame;
    private ProgramManager pm;
    private SubscriptionManager sm;

    // Start setting up the frame
    @Override
    public void run() {
        pm = new ProgramManager();
        sm = new SubscriptionManager();

        frame = new JFrame("Netflix Statistix");
        frame.setLayout(new BorderLayout());
        frame.setPreferredSize(new Dimension(1200, 500));
        frame.setMinimumSize(new Dimension(500, 450));
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
        container.add(new NavigationPanel(new Dimension(container.getWidth(), container.getHeight()-footerHeight), this), BorderLayout.CENTER);
        container.add(new FooterPanel(new Dimension(container.getWidth(), footerHeight)), BorderLayout.SOUTH);
    }

    public SubscriptionManager getSubscriptionManager() {
        return this.sm;
    }

    public ProgramManager getProgramManager() {
        return this.pm;
    }
}
