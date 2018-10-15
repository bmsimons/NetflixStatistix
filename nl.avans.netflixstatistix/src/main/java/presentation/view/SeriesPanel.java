package main.java.presentation.view;

import javax.swing.*;
import java.awt.*;

public class SeriesPanel extends JPanel {
    public SeriesPanel(Dimension size){
        setPreferredSize(new Dimension(size));
        GridBagConstraints constraints = new GridBagConstraints();
        setLayout(new GridBagLayout());

        // Set the constraints, change when adding another one to the center panel
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.insets = new Insets(5,5,5,0);

        // Test data
        String[] seriesData = {"House of Cards","The Story of Mr. Dab","Sesame Street","Minecraft"};
        // String[] data = logic.getData(String data)

        // Center Panel Components
        JLabel seriesLabel = new JLabel("Selecteer serie");
        JComboBox<String> seriesComboBox = new JComboBox<String>(seriesData);

        JLabel seriesAverageLabel = new JLabel("Gemiddeld % bekeken per aflevering");
        JTextArea seriesAverageTextArea = new JTextArea("Aflevering 1: 55%\n" +
                "Aflevering 2: 100%\n" +
                "Aflevering 3: 75%\n" +
                "Aflevering 4: 20%\n");
        seriesAverageTextArea.setDisabledTextColor(Color.BLACK);
        // Set the size of the textarea
        // TODO: Make the textarea scrollable, dynamic width
        seriesAverageTextArea.setPreferredSize(new Dimension(350,250));
        seriesAverageTextArea.setEnabled(false);

        // Add the components to the panel
        add(seriesLabel,constraints);

        constraints.gridx = 1;
        add(seriesComboBox, constraints);

        constraints.gridy = 2;
        constraints.gridx = 0;
        add(seriesAverageLabel, constraints);

        constraints.gridy = 3;
        constraints.gridx = 0;
        constraints.gridwidth = 3;
        constraints.fill = GridBagConstraints.VERTICAL;
        add(seriesAverageTextArea, constraints);
    }
}
