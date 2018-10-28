package presentation.events;

import data.SubscriptionDAO;
import domain.Subscription;
import logic.SubscriptionManager;
import presentation.SubscriptionCreatePanel;
import presentation.UserInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubscriptionCreateListener implements ActionListener {

    private SubscriptionCreatePanel panel;
    private SubscriptionManager sm;

    public SubscriptionCreateListener(SubscriptionCreatePanel panel) {
        this.panel = panel;
        UserInterface ui = panel.getUi();
        sm = ui.getSubscriptionManager();
    }

    // When the button gets pressed, this actionListener will check if the input is valid and send the data to the manager so it can be added to the database
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!this.SubscriptionNameValid()){
            JOptionPane.showMessageDialog(null, "Naam is ongeldig");
        }
        else if(!this.SubscriptionAgeValid()){
            JOptionPane.showMessageDialog(null, "Leeftijd is ongeldig");
        }
        else if(!this.SubscriptionStreetValid()){
            JOptionPane.showMessageDialog(null, "Straatnaam is ongeldig");
        }
        else if(!this.SubscriptionHouseNoValid()){
            JOptionPane.showMessageDialog(null, "Huisnummer is ongeldig");
        }
        else if(!this.SubscriptionHouseNoAdditionValid()){
            JOptionPane.showMessageDialog(null, "Huisnummer toevoeging is ongeldig");
        }
        else if(!this.SubscriptionCityValid()){
            JOptionPane.showMessageDialog(null, "Stad is ongeldig");
        }
        else{
            SubscriptionDAO sdao = new SubscriptionDAO();

            Subscription newSub = new Subscription(
                    panel.getNameTextField().getText(),
                    panel.getStreetTextField().getText(),
                    panel.getCityTextField().getText(),
                    Integer.parseInt(panel.getHouseNumberTextField().getText()),
                    panel.getHouseNumberAdditionTextField().getText(),
                    0
            );

            panel.setResult(sm.addSubscription(newSub, Integer.parseInt(panel.getAgeTextField().getText())));
        }

    }

    public boolean SubscriptionNameValid(){
        //check if name is null
        if ((panel.getNameTextField().getText()).trim().equals("")){
            return false;
        }
        //check if name is to long
        else if((panel.getNameTextField().getText()).length() > 150){
            return false;
        }
        //check if subscription has a whitespace for first and last name
        else if(!(panel.getNameTextField().getText()).contains(" ")){
            return false;
        }

        return true;
    }

    public boolean SubscriptionAgeValid(){
        //check if age is not empty
        if ((panel.getAgeTextField().getText()).trim().equals("")){
            return false;
        }
        else if(!panel.getAgeTextField().getText().matches("-?(0|[1-9]\\d*)")){
            return false;
        }
        //check if age is to high
        else if(Integer.parseInt(panel.getAgeTextField().getText()) > 100 || Integer.parseInt(panel.getAgeTextField().getText()) < 0){
            return false;
        }
        //check if age field does not contain whitespaces
        else if((panel.getAgeTextField().getText()).contains(" ")){
            return false;
        }

        return true;
    }

    public boolean SubscriptionStreetValid(){
        //check if name is null
        if ((panel.getStreetTextField().getText()).trim().equals("")){
            return false;
        }
        //check if name is to long
        else if((panel.getStreetTextField().getText()).length() > 200){
            return false;
        }

        return true;
    }

    public boolean SubscriptionHouseNoValid(){
        //check if houseNumber is null
        if ((panel.getHouseNumberTextField().getText()).trim().equals("")){
            return false;
        }
        //check if Housenumber is to high
        else if(Integer.parseInt(panel.getHouseNumberTextField().getText()) > 25000 || Integer.parseInt(panel.getHouseNumberTextField().getText()) < 0){
            return false;
        }
        //check if housenumber is numeric
        else if(!panel.getHouseNumberTextField().getText().matches("^(0|[1-9][0-9]*)$")){
            return false;
        }

        return true;
    }

    public boolean SubscriptionHouseNoAdditionValid(){
        //check if Housenumber addition is to long
        if(panel.getHouseNumberAdditionTextField().getText().length() > 10){
            return false;
        }

        return true;
    }

    public boolean SubscriptionCityValid(){

        //check if city is not null
        if(panel.getCityTextField().getText().trim().equals("")){
            return false;
        }

        return true;
    }
}
