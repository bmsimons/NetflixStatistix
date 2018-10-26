package presentation;

import presentation.events.ChooseProfileItemListener;
import presentation.events.SearchSubscriberActionListener;

import javax.swing.*;
import java.awt.*;

public class ProfilePanel extends JPanel {
    private UserInterface ui;
    private JTextField subscriptionTextField;
    private JLabel resultLabel;
    private JTextArea resultTextArea;
    private JComboBox<String> seriesComboBox;
    private Integer subscriberID;

    public ProfilePanel(Dimension size, UserInterface ui){
        this.ui = ui;

        setPreferredSize(new Dimension(size));
        GridBagConstraints constraints = new GridBagConstraints();
        setLayout(new GridBagLayout());

        String[] profileData = {"Thimo","Floris","Bart","Mike Wazowski","Buzz Lightyear"};

        subscriptionTextField = new JTextField();
        subscriptionTextField.setPreferredSize(new Dimension(220, 24));
        JButton searchButton = new JButton("Zoek Abonnee");
        searchButton.addActionListener(new SearchSubscriberActionListener(this));

        JLabel profileLabel = new JLabel("Selecteer een profiel");
        seriesComboBox = new JComboBox<String>(profileData);
        seriesComboBox.setSelectedIndex(3);
        seriesComboBox.addItemListener(new ChooseProfileItemListener(this));

        // TODO: Add an ActionListener that fetches the data of the selected user

        resultLabel = new JLabel("Gegevens voor Mike Wazowski");
        resultTextArea = new JTextArea(13, 35);

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

    public UserInterface getUi() {
        return this.ui;
    }

    public JTextField getSubscriptionTextField() {
        return this.subscriptionTextField;
    }

    public JLabel getResultLabel() {
        return this.resultLabel;
    }

    public JTextArea getResultTextArea() {
        return this.resultTextArea;
    }

    public JComboBox<String> getSeriesComboBox() {
        return this.seriesComboBox;
    }

    public Integer getSubscriberID() {
        return this.subscriberID;
    }

    public void setSubscriberID(Integer subscriberID) {
        this.subscriberID = subscriberID;
    }
}
