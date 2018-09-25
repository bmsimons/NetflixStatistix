package main.java.presentation.view;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class UserInterface implements Runnable, UI {

    private JFrame mainFrame;

    @Override
    public void run() {
        this.mainFrame = new JFrame("Netflix Statistix");

        this.mainFrame.setPreferredSize(new Dimension(500, 500));
        this.mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(this.mainFrame.getContentPane());

        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    @Override
    public void createComponents(Container container) {
        JPanel borderPanel = new JPanel();
        borderPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        this.mainFrame.add(borderPanel, BorderLayout.SOUTH);

        borderPanel.setPreferredSize(new Dimension(this.mainFrame.getWidth(), 24));
        borderPanel.setLayout(new BorderLayout());

        JLabel leftBorderLabel = new JLabel("Netflix Statistix");
        leftBorderLabel.setHorizontalAlignment(SwingConstants.LEFT);
        borderPanel.add(leftBorderLabel);

        JLabel rightBorderLabel = new JLabel("Informatica 2018 23IVK1 - Bart, Floris en Thimo");
        rightBorderLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        borderPanel.add(rightBorderLabel, BorderLayout.LINE_END);

        JPanel topPanel = new JPanel();
        // topPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        this.mainFrame.add(topPanel, BorderLayout.NORTH);

        topPanel.setPreferredSize(new Dimension(this.mainFrame.getWidth(), 24));
        topPanel.setLayout(new BorderLayout());

        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenu1 = new JMenu("Overzicht 1");
        JMenu jMenu2 = new JMenu("Overzicht 2");
        JMenu jMenu3 = new JMenu("Overzicht 3");
        JMenu jMenu4 = new JMenu("Overzicht 4");

        jMenuBar.add(jMenu1);
        jMenuBar.add(jMenu2);
        jMenuBar.add(jMenu3);
        jMenuBar.add(jMenu4);

        topPanel.add(jMenuBar);
    }
}
