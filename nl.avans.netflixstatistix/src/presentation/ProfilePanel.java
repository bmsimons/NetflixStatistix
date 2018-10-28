package presentation;

import presentation.events.ChooseProfileItemListener;
import presentation.events.SearchSubscriberActionListener;

import javax.swing.*;
import java.awt.*;

// Panel that displays information about chosen profile

public class ProfilePanel extends JPanel {
    private UserInterface ui;
    private JTextField subscriptionTextField;
    private JLabel resultLabel;
    private JTextArea resultTextArea;
    private JComboBox<String> profileComboBox;
    private Integer subscriberID;

    public ProfilePanel(Dimension size, UserInterface ui){
        this.ui = ui;

        setPreferredSize(new Dimension(size));
        GridBagConstraints constraints = new GridBagConstraints();
        setLayout(new GridBagLayout());

        subscriptionTextField = new JTextField();
        subscriptionTextField.setPreferredSize(new Dimension(220, 24));
        JButton searchButton = new JButton("Zoek Abonnee");
        searchButton.addActionListener(new SearchSubscriberActionListener(this));

        JLabel profileLabel = new JLabel("Selecteer een profiel");
        profileComboBox = new JComboBox<String>();
        profileComboBox.addItemListener(new ChooseProfileItemListener(this));

        resultLabel = new JLabel("Selecteer een profiel");
        resultTextArea = new JTextArea(13, 35);

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
        add(profileComboBox, constraints);

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

    public JComboBox<String> getProfileComboBox() {
        return this.profileComboBox;
    }

    public Integer getSubscriberID() {
        return this.subscriberID;
    }

    public void setSubscriberID(Integer subscriberID) {
        this.subscriberID = subscriberID;
    }
}
