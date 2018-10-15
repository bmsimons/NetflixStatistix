package main.java.data;

import java.util.Date;

public class Profile {
    private int ProfileID;
    private int SubscriptionID;
    private Date BirthDate;

    public Profile(int profileID, int subscriptionID, Date birthDate) {
        this.ProfileID = profileID;
        this.SubscriptionID = subscriptionID;
        this.BirthDate = birthDate;
    }

    public int getProfileID() {
        return this.ProfileID;
    }

    public int getSubscriptionID() {
        return this.SubscriptionID;
    }

    public Date getBirthDate() {
        return this.BirthDate;
    }

    public void setProfileID(int profileID) {
        this.ProfileID = profileID;
    }

    public void setSubscriptionID(int subscriptionID) {
        this.SubscriptionID = subscriptionID;
    }

    public void setBirthDate(Date birthDate) {
        this.BirthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (o.getClass() != this.getClass()) {
            return false;
        }

        Profile p = (Profile) o;

        if (p.getProfileID() == this.getProfileID()) {
            return true;
        } else {
            return false;
        }
    }
}
