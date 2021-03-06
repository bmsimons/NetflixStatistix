package logic;

import data.ProfileDAO;
import data.SubscriptionDAO;
import domain.Profile;
import domain.Subscription;

import java.util.ArrayList;
import java.util.Set;

public class SubscriptionManager {

    private ArrayList<Subscription> subscriptions;

    public SubscriptionManager() {
        subscriptions = new ArrayList<>();
    }

    // Returns a list of all subscriptions
    public ArrayList<Subscription> getSubscriptions(){

        SubscriptionDAO subdao = new SubscriptionDAO();

        subscriptions = subdao.getAll();

        for(Subscription s : subscriptions){
            ProfileDAO pdao = new ProfileDAO();

            s.setProfiles(pdao.getAllBySub(s));
        }

        return subscriptions;
    }

    // Returns a set of subscriptions that only have 1 profile
    public Set<Subscription> getSubscriptionsWithOnlyOneProfile() {
        SubscriptionDAO subdao = new SubscriptionDAO();

        return subdao.getSubscriptionsWithOnlyOneProfile();
    }

    // Returns a set of seriesID's based on given subscriberID (watched by profiles associated with subscription)
    public Set<Integer> getAllSeriesForSubscriber(int subscriberID) {

        SubscriptionDAO subdao = new SubscriptionDAO();

        Set<Integer> seriesIDs = subdao.getAllSeriesForSubscriber(subscriberID);

        return seriesIDs;
    }

    // Returns a set of profiles that are associated with given subscription
    public Set<Profile> getProfilesForSubscription(Subscription s) {
        SubscriptionDAO subdao = new SubscriptionDAO();

        return subdao.getProfilesForSubscription(s);
    }

    // Returns a profile based on given profilename and subscriptionID
    public Profile getProfileByNameAndSubscriberId(String profileName, Integer subscriberID) {
        ProfileDAO pdao = new ProfileDAO();

        return pdao.getProfileByNameAndSubscriberId(profileName, subscriberID);
    }

    // Returns a set of profiles that are associated with given subscriptionID
    public Set<Profile> getProfilesForSubscriptionID(int subscriptionID){
        SubscriptionDAO s = new SubscriptionDAO();
        return s.getProfilesForSubscriptionID(subscriptionID);
    }

    // Inserts a profile into the database
    public boolean addProfile(Profile profile){
        ProfileDAO p = new ProfileDAO();
        boolean result = p.insert(profile);
        if(result){
            this.getSubscriptions();
        }
        return result;
    }

    // Inserts a subscription into the database
    public boolean addSubscription(Subscription subscription, int age){
        SubscriptionDAO s = new SubscriptionDAO();

        boolean result = s.insert(subscription);

        if(result){
            for (Subscription sub : this.getSubscriptions()){
                if (sub.getName().equals(subscription.getName()) && sub.getStreetName().equals(subscription.getStreetName())){
                    String profilename = (sub.getName()).split(" ")[0];

                    this.addProfile(new Profile(profilename, age, sub.getId()));
                }
            }
        }

        return result;
    }

}
