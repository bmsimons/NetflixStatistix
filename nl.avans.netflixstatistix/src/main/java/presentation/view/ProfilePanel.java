package main.java.presentation.view;

import javax.swing.*;
import java.awt.*;

public class ProfilePanel extends JPanel {
    public ProfilePanel(Dimension size){
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

        String[] profileData = {"Thimo","Floris","Bart","Mike Wazowski","Buzz Lightyear"};

        JLabel subscriptionLabel = new JLabel("Zoek een abonnement:");
        JTextField subscriptionTextField = new JTextField();
        subscriptionTextField.setPreferredSize(new Dimension(150, 20));
        JButton subscriptionSearchButton = new JButton("Zoek Abonnee");

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

        add(subscriptionLabel, constraints);

        constraints.gridx = 1;
        add(subscriptionTextField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        add(subscriptionSearchButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        add(profileLabel, constraints);

        constraints.gridx = 1;
        add(seriesComboBox, constraints);

        constraints.gridy = 3;
        constraints.gridx = 0;
        add(profileResultLabel, constraints);

        constraints.gridy = 4;
        constraints.gridx = 0;
        constraints.gridwidth = 3;
        constraints.fill = GridBagConstraints.VERTICAL;
        add(profileResultTextArea, constraints);
    }
}
