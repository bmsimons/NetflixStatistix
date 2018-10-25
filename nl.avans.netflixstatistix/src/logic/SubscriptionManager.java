package logic;

import data.ProfileDAO;
import data.SubscriptionDAO;
import domain.Subscription;

import java.util.ArrayList;

public class SubscriptionManager {

    private ArrayList<Subscription> subscriptions;

    public SubscriptionManager() {
        subscriptions = new ArrayList<>();
    }

    public ArrayList<Subscription> getSubscriptions(){

        SubscriptionDAO subdao = new SubscriptionDAO();

        subscriptions = subdao.getAll();

        for(Subscription s : subscriptions){
            ProfileDAO pdao = new ProfileDAO();

            s.setProfiles(pdao.getAllBySub(s));
        }

        return subscriptions;
    }
}
