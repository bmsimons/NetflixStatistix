package presentation;

import javax.swing.*;
import java.awt.*;

public class ProfilePanel extends JPanel {
    public ProfilePanel(Dimension size){
        setPreferredSize(new Dimension(size));
        GridBagConstraints constraints = new GridBagConstraints();
        setLayout(new GridBagLayout());

        String[] profileData = {"Thimo","Floris","Bart","Mike Wazowski","Buzz Lightyear"};

        JTextField subscriptionTextField = new JTextField();
        subscriptionTextField.setPreferredSize(new Dimension(220, 24));
        JButton searchButton = new JButton("Zoek Abonnee");

        // TODO: Add an ActionListener that fetches the list of profiles from an subscriber

        JLabel profileLabel = new JLabel("Selecteer een profiel");
        JComboBox<String> seriesComboBox = new JComboBox<String>(profileData);
        seriesComboBox.setSelectedIndex(3);

        // TODO: Add an ActionListener that fetches the data of the selected user

        JLabel resultLabel = new JLabel("Gegevens voor Mike Wazowski");
        JTextArea resultTextArea = new JTextArea(13, 35);

        resultTextArea.setText("Naam: Mike Wazowski\n" +
                "Straatnaam: Monster Ave\n" +
                "Huisnummer: 20\n" +
                "Toevoeging: -\n" +
                "Woonplaats: Monstropolis\n" +
                "Leeftijd: 31");
        resultTextArea.setEditable(false);
        resultTextArea.setDisabledTextColor(Color.BLACK);

        JScrollPane scrollPane = new JScrollPane(resultTextArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        // Set the constraints, add the components to the panel
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.insets = new Insets(5,5,5,0);
        constraints.gridx = 0;
        add(subscriptionTextField, constraints);

        constraints.gridx = 2;
        constraints.gridwidth = 1;
        add(searchButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        add(profileLabel, constraints);

        constraints.gridx = 2;
        constraints.gridwidth = 1;
        add(seriesComboBox, constraints);

        constraints.gridwidth = 1;
        constraints.gridy = 2;
        constraints.gridx = 0;
        add(resultLabel, constraints);

        constraints.gridy = 3;
        constraints.gridx = 0;
        constraints.gridwidth = 3;
        constraints.fill = GridBagConstraints.VERTICAL;
        add(scrollPane, constraints);
    }
}
