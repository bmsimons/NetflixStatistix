package main.java.presentation.view;

import javax.swing.*;
import java.awt.*;

public class ProfileCreatePanel extends JPanel {
    private JTextField nameTextField, subscriptionTextField, dateTextField;
    private JLabel resultLabel;
    public ProfileCreatePanel(Dimension size){
        setPreferredSize(size);
        GridBagConstraints constraints = new GridBagConstraints();
        setLayout(new GridBagLayout());

        // Create the components
        JLabel subscriptionLabel = new JLabel("Abonnement nummer:");
        subscriptionTextField = new JTextField();
        subscriptionTextField.setPreferredSize(new Dimension(175, 24));

        JLabel nameLabel = new JLabel("Naam:");
        nameTextField = new JTextField();
        nameTextField.setPreferredSize(new Dimension(175, 24));

        JLabel dateLabel = new JLabel("Geboortedatum:");
        dateTextField = new JTextField();
        dateTextField.setPreferredSize(new Dimension(175, 24));

        // TODO Add an ActionListener that sends all the data to the apl. logic
        JButton addButton = new JButton("Voeg profiel toe!");

        // TODO set resultLabel's text to be a result of whether the profile got added or not
        resultLabel = new JLabel();

        // Set the constraints, add components to panel
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(5,5,5,0);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(subscriptionLabel, constraints);

        constraints.gridx = 1;
        add(subscriptionTextField, constraints);

        constraints.gridy = 1;
        constraints.gridx = 0;
        add(nameLabel, constraints);

        constraints.gridx = 1;
        add(nameTextField, constraints);

        constraints.gridy = 2;
        constraints.gridx = 0;
        add(dateLabel, constraints);

        constraints.gridx = 1;
        add(dateTextField, constraints);

        constraints.gridy = 3;
        constraints.gridx = 0;
        add(addButton, constraints);

        constraints.gridy = 4;
        add(resultLabel, constraints);
    }

    public void setResult(boolean success){
        String resultText = "Het toevoegen van het profiel is ";
        resultText += (success? "gelukt." : "mislukt.");
        resultLabel.setText(resultText);
    }

    public void clear(){
        subscriptionTextField.setText("");
        nameTextField.setText("");
        dateTextField.setText("");
    }
}
