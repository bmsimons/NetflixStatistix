package main.java.presentation.view;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class UserInterface implements Runnable, UI {

    private JFrame mainFrame;

    @Override
    public void run() {
        mainFrame = new JFrame("Netflix Statistix");

        mainFrame.setPreferredSize(new Dimension(500, 500));

        // TODO: Set a proper minimum size
        mainFrame.setMinimumSize(mainFrame.getPreferredSize());
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(mainFrame.getContentPane());

        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    @Override
    public void createComponents(Container container) {
        // Top Panel | Navigation Bar
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(container.getWidth(), 24));
        topPanel.setLayout(new GridLayout(1,4));
        // topPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        // Navigation bar
        JButton programButton = new JButton("Programma");
        JButton profileButton = new JButton("Profiel");
        JButton jButton3 = new JButton("Overzicht 3");
        JButton jButton4 = new JButton("Overzicht 4");

        programButton.setEnabled(false);
        topPanel.add(programButton);
        topPanel.add(profileButton);
        topPanel.add(jButton3);
        topPanel.add(jButton4);

        // Center Panel | Body
        JPanel centerPanel = new JPanel();
        replaceCenterPanel(centerPanel, "Programma");

        // Bottom Panel | Footer
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        bottomPanel.setPreferredSize(new Dimension(container.getWidth(), 24));
        bottomPanel.setLayout(new BorderLayout());

        // Bottom Panel Components
        JLabel projectNameLabel = new JLabel("Netflix Statistix");
        projectNameLabel.setHorizontalAlignment(SwingConstants.LEFT);

        JLabel projectMembersLabel = new JLabel("Informatica 2018 23IVK1 - Bart, Floris en Thimo");
        projectMembersLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        bottomPanel.add(projectNameLabel);
        bottomPanel.add(projectMembersLabel, BorderLayout.LINE_END);

        // ActionListeners
        programButton.addActionListener(new ProgramMenuListener(this, centerPanel, topPanel));
        profileButton.addActionListener(new ProfileMenuListener(this, centerPanel, topPanel));

        // Add items to the container
        container.add(topPanel, BorderLayout.NORTH);
        container.add(centerPanel);
        container.add(bottomPanel, BorderLayout.SOUTH);
    }

    public void disableSelectedButton(JPanel panel, String buttonName){
        Component[] components = panel.getComponents();
        for(Component component : components){
            if (component.getClass() == JButton.class){
                JButton button = (JButton)component;
                button.setEnabled(!button.getText().equals(buttonName));
            }
        }
    }

    public void replaceCenterPanel(JPanel centerPanel, String contentName){
        // Empty the center panel
        centerPanel.removeAll();

        // Set panel layout + size
        centerPanel.setPreferredSize(new Dimension(centerPanel.getWidth(), (centerPanel.getHeight())));
        GridBagLayout centerPanelLayout = new GridBagLayout();
        GridBagConstraints centerPanelConstraints = new GridBagConstraints();
        centerPanel.setLayout(centerPanelLayout);

        // Set the constraints, change when adding another one to the center panel
        centerPanelConstraints.fill = GridBagConstraints.HORIZONTAL;
        centerPanelConstraints.gridx = 0;
        centerPanelConstraints.gridy = 0;
        centerPanelConstraints.gridwidth = 1;
        centerPanelConstraints.gridheight = 1;
        centerPanelConstraints.insets = new Insets(5,5,5,0);

        if (contentName.equals("Programma")){
            // Test data
            String[] seriesData = {"House of Cards","The Story of Mr. Dab","Sesame Street","Minecraft"};
            Integer[] seriesSeasonsData = {1,2,3,4,5,6,7,8,9,10};

            // Center Panel Components
            JLabel seriesLabel = new JLabel("Selecteer serie");
            JComboBox<String> seriesComboBox = new JComboBox<String>(seriesData);
            JLabel seriesSeasonLabel = new JLabel("Selecteer seizoen");
            JComboBox<Integer> seriesSeasonList = new JComboBox<Integer>(seriesSeasonsData);

            JLabel seriesAverageLabel = new JLabel("Gemiddeld % bekeken per aflevering");
            JTextArea seriesSeasonTextArea = new JTextArea("Aflevering 1: 55%\n" +
                        "Aflevering 2: 100%\n" +
                        "Aflevering 3: 75%\n" +
                        "Aflevering 4: 20%\n");
            seriesSeasonTextArea.setDisabledTextColor(Color.BLACK);
            // Set the size of the textarea
            // TODO: Make the textarea scrollable, dynamic width
            seriesSeasonTextArea.setPreferredSize(new Dimension(350,250));
            seriesSeasonTextArea.setEnabled(false);

            // Add the components to the center panel
            centerPanel.add(seriesLabel,centerPanelConstraints);

            centerPanelConstraints.gridx = 1;
            centerPanel.add(seriesComboBox, centerPanelConstraints);

            centerPanelConstraints.gridy = 1;
            centerPanelConstraints.gridx = 0;
            centerPanel.add(seriesSeasonLabel, centerPanelConstraints);

            centerPanelConstraints.gridy = 1;
            centerPanelConstraints.gridx = 1;
            centerPanel.add(seriesSeasonList, centerPanelConstraints);

            centerPanelConstraints.gridy = 2;
            centerPanelConstraints.gridx = 0;
            centerPanel.add(seriesAverageLabel, centerPanelConstraints);

            centerPanelConstraints.gridy = 3;
            centerPanelConstraints.gridx = 0;
            centerPanelConstraints.gridwidth = 3;
            centerPanelConstraints.fill = GridBagConstraints.VERTICAL;
            centerPanel.add(seriesSeasonTextArea, centerPanelConstraints);
        }else if (contentName.equals("Profiel")){
            String[] profileData = {"Thimo","Floris","Bart","Mike Wazowski","Buzz Lightyear"};

            JLabel subscriptionLabel = new JLabel("Zoek een abonnement:");
            JTextField subscriptionTextField = new JTextField();
            subscriptionTextField.setPreferredSize(new Dimension(150, 20));

            JLabel profileLabel = new JLabel("Selecteer een profiel");
            JComboBox<String> seriesComboBox = new JComboBox<String>(profileData);
            seriesComboBox.setSelectedIndex(3);


            JLabel profileResultLabel = new JLabel("Gegevens voor Mike Wazowski");
            JTextArea profileResultTextArea = new JTextArea("Naam: Mike Wazowski\n" +
                    "Straatnaam: Monster Ave\n" +
                    "Huisnummer: 20\n" +
                    "Toevoeging: -\n" +
                    "Woonplaats: Monstropolis\n" +
                    "Leeftijd: 31");

            // TODO: Make the textarea scrollable, dynamic width
            profileResultTextArea.setPreferredSize(new Dimension(350,250));
            profileResultTextArea.setEnabled(false);
            profileResultTextArea.setDisabledTextColor(Color.BLACK);

            centerPanel.add(subscriptionLabel, centerPanelConstraints);

            centerPanelConstraints.gridx = 1;
            centerPanel.add(subscriptionTextField, centerPanelConstraints);

            centerPanelConstraints.gridx = 0;
            centerPanelConstraints.gridy = 1;
            centerPanel.add(profileLabel, centerPanelConstraints);

            centerPanelConstraints.gridx = 1;
            centerPanel.add(seriesComboBox, centerPanelConstraints);

            centerPanelConstraints.gridy = 2;
            centerPanelConstraints.gridx = 0;
            centerPanel.add(profileResultLabel, centerPanelConstraints);

            centerPanelConstraints.gridy = 3;
            centerPanelConstraints.gridx = 0;
            centerPanelConstraints.gridwidth = 3;
            centerPanelConstraints.fill = GridBagConstraints.VERTICAL;
            centerPanel.add(profileResultTextArea, centerPanelConstraints);
        }
    }

    public void refresh(){
        mainFrame.revalidate();
        mainFrame.repaint();
    }
}
