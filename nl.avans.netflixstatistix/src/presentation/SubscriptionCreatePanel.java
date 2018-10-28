package presentation;

import domain.Subscription;
import presentation.events.SubscriptionCreateListener;

import javax.swing.*;
import java.awt.*;

public class SubscriptionCreatePanel extends JPanel {

    private JTextField nameTextField, ageTextField, streetTextField, houseNumberTextField, houseNumberAdditionTextField, cityTextField;
    private JLabel resultLabel;
    private UserInterface ui;

    public SubscriptionCreatePanel(Dimension size, UserInterface ui){
        this.ui = ui;
        setPreferredSize(size);
        GridBagConstraints constraints = new GridBagConstraints();
        setLayout(new GridBagLayout());

        // Create the components
        JLabel nameLabel = new JLabel("Naam:");
        nameTextField = new JTextField();
        nameTextField.setPreferredSize(new Dimension(175, 24));

        JLabel birthDateLabel = new JLabel("Leeftijd:");
        ageTextField = new JTextField();
        ageTextField.setPreferredSize(new Dimension(175, 24));

        JLabel streetLabel = new JLabel("Straatnaam:");
        streetTextField = new JTextField();
        streetTextField.setPreferredSize(new Dimension(175, 24));

        JLabel houseNumberLabel = new JLabel("Huisnummer:");
        houseNumberTextField = new JTextField();
        houseNumberTextField.setPreferredSize(new Dimension(175, 24));

        JLabel houseNumberAdditionLabel = new JLabel("Toevoeging:");
        houseNumberAdditionTextField = new JTextField();
        houseNumberAdditionTextField.setPreferredSize(new Dimension(175, 24));

        JLabel cityLabel = new JLabel("Woonplaats:");
        cityTextField = new JTextField();
        cityTextField.setPreferredSize(new Dimension(175, 24));

        // TODO Add an ActionListener that sends all the data to the apl. logic
        JButton addButton = new JButton("Voeg abonnee toe!");

        //Actionlistener for creating the subscription
        addButton.addActionListener(new SubscriptionCreateListener(this));

        // TODO set resultLabel's text to be a result of whether the profile got added or not
        resultLabel = new JLabel();

        // Set the constraints, add components to panel
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(5,5,5,0);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(nameLabel, constraints);

        constraints.gridx = 1;
        add(nameTextField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        add(birthDateLabel, constraints);

        constraints.gridx = 1;
        add(ageTextField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        add(streetLabel, constraints);

        constraints.gridx = 1;
        add(streetTextField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        add(houseNumberLabel, constraints);

        constraints.gridx = 1;
        add(houseNumberTextField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        add(houseNumberAdditionLabel, constraints);

        constraints.gridx = 1;
        add(houseNumberAdditionTextField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 5;
        add(cityLabel, constraints);

        constraints.gridx = 1;
        add(cityTextField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 6;
        add(addButton, constraints);

        constraints.gridy = 7;
        add(resultLabel, constraints);
    }

    public void clear(){
        nameTextField.setText("");
        ageTextField.setText("");
        streetTextField.setText("");
        houseNumberTextField.setText("");
        houseNumberAdditionTextField.setText("");
        cityTextField.setText("");
    }

    public JTextField getNameTextField() {
        return nameTextField;
    }

    public JTextField getAgeTextField() {
        return ageTextField;
    }

    public JTextField getStreetTextField() {
        return streetTextField;
    }

    public JTextField getHouseNumberTextField() {
        return houseNumberTextField;
    }

    public JTextField getHouseNumberAdditionTextField() {
        return houseNumberAdditionTextField;
    }

    public JTextField getCityTextField() {
        return cityTextField;
    }

    public void setResult(boolean success){
        String resultText = "Het toevoegen van het profiel is ";
        resultText += (success? "gelukt." : "mislukt.");
        resultLabel.setText(resultText);
    }

    public UserInterface getUi(){ return this.ui; }
}
