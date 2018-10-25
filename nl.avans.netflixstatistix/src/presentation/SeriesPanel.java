package main.java.presentation.view;

import javax.swing.*;
import java.awt.*;

public class SeriesPanel extends JPanel {
    public SeriesPanel(Dimension size){
        setPreferredSize(new Dimension(size));
        GridBagConstraints constraints = new GridBagConstraints();
        setLayout(new GridBagLayout());

        // Test data
        String[] seriesData = {"House of Cards","The Story of Mr. Dab","Sesame Street","Minecraft"};
        // String[] data = logic.getData(String data)

        // Center Panel Components
        JLabel seriesLabel = new JLabel("Selecteer serie");
        JComboBox<String> seriesComboBox = new JComboBox<String>(seriesData);

        JLabel seriesAverageLabel = new JLabel("Gemiddeld % bekeken per aflevering");
        JTextArea seriesAverageTextArea = new JTextArea(13, 35);
        seriesAverageTextArea.setText("Selecteer een serie.");
        seriesAverageTextArea.setDisabledTextColor(Color.BLACK);
        seriesAverageTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(seriesAverageTextArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        // Set the constraints, add the components to the panel
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.insets = new Insets(5,5,5,0);
        add(seriesLabel,constraints);

        constraints.gridx = 1;
        add(seriesComboBox, constraints);

        constraints.gridy = 2;
        constraints.gridx = 0;
        add(seriesAverageLabel, constraints);

        constraints.gridy = 3;
        constraints.gridwidth = 3;
        constraints.fill = GridBagConstraints.VERTICAL;
        add(scrollPane, constraints);
    }
}
