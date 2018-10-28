package presentation;

import domain.Subscription;
import presentation.events.ProfileCreateActionListener;

import javax.swing.*;
import java.awt.*;

// Panel that displays a form which is used to create profiles with.

public class ProfileCreatePanel extends JPanel {
    private JTextField nameTextField, ageTextField;
    private JComboBox<Subscription> subscriptionComboBox;
    private JLabel resultLabel;
    private UserInterface ui;
    public ProfileCreatePanel(Dimension size, UserInterface ui){
        this.ui = ui;
        setPreferredSize(size);
        GridBagConstraints constraints = new GridBagConstraints();
        setLayout(new GridBagLayout());

        // Create the components
        JLabel subscriptionLabel = new JLabel("Abonnee:");
        // Data will be fetched on page load.
        subscriptionComboBox = new JComboBox<Subscription>();

        JLabel nameLabel = new JLabel("Naam:");
        nameTextField = new JTextField();
        nameTextField.setPreferredSize(new Dimension(175, 24));

        JLabel dateLabel = new JLabel("Leeftijd:");
        ageTextField = new JTextField();
        ageTextField.setPreferredSize(new Dimension(175, 24));

        JButton addButton = new JButton("Voeg profiel toe!");
        addButton.addActionListener(new ProfileCreateActionListener(this));

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
        add(subscriptionComboBox, constraints);

        constraints.gridy = 1;
        constraints.gridx = 0;
        add(nameLabel, constraints);

        constraints.gridx = 1;
        add(nameTextField, constraints);

        constraints.gridy = 2;
        constraints.gridx = 0;
        add(dateLabel, constraints);

        constraints.gridx = 1;
        add(ageTextField, constraints);

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
        nameTextField.setText("");
        ageTextField.setText("");
    }

    public JComboBox<Subscription> getSubscriptionComboBox(){
        return subscriptionComboBox;
    }
    
    public Subscription getSelectedSubscription(){
        return (Subscription)subscriptionComboBox.getSelectedItem();
    }
    
    public String getAgeTextFieldText(){
        return ageTextField.getText();
    }

    public String getNameTextFieldText(){
        return nameTextField.getText();
    }

    public UserInterface getUi(){
        return ui;
    }
}
