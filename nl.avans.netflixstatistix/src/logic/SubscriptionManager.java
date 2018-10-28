package logic;

import data.ProfileDAO;
import data.SubscriptionDAO;
import domain.Profile;
import domain.Subscription;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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

    public Set<Subscription> getSubscriptionsWithOnlyOneProfile() {
        SubscriptionDAO subdao = new SubscriptionDAO();

        return subdao.getSubscriptionsWithOnlyOneProfile();
    }

    public Set<Integer> getAllSeriesForSubscriber(int subscriberID) {

        SubscriptionDAO subdao = new SubscriptionDAO();

        Set<Integer> seriesIDs = subdao.getAllSeriesForSubscriber(subscriberID);

        return seriesIDs;
    }

    public Set<Profile> getProfilesForSubscription(Subscription s) {
        SubscriptionDAO subdao = new SubscriptionDAO();

        return subdao.getProfilesForSubscription(s);
    }

    public Profile getProfileByNameAndSubscriberId(String profileName, Integer subscriberID) {
        ProfileDAO pdao = new ProfileDAO();

        return pdao.getProfileByNameAndSubscriberId(profileName, subscriberID);
    }

    public Set<Profile> getProfilesForSubscriptionID(int subscriptionID){
        SubscriptionDAO s = new SubscriptionDAO();
        return s.getProfilesForSubscriptionID(subscriptionID);
    }

}
