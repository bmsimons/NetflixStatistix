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
        SubscriptionManager SM = new SubscriptionManager();
//        ProgramManager PM = new ProgramManager();

        UserInterface ui = new UserInterface();

        SwingUtilities.invokeLater(ui);

        for(Subscription s : SM.getSubscriptions()){
            for (Profile p : s.getProfiles()){
                System.out.println(p.getProfileName());
            }
        }
    }
}
