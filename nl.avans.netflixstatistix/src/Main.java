import domain.Episode;
import domain.Profile;
import domain.Series;
import domain.Subscription;
import logic.ProgramManager;
import logic.SubscriptionManager;
import presentation.UserInterface;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();

        SwingUtilities.invokeLater(ui);

        SubscriptionManager PM = new SubscriptionManager();

        for(Subscription s : PM.getSubscriptions()){
            for (Profile p : s.getProfiles()){
                System.out.println(p.getProfileName());
            }
        }
    }
}
