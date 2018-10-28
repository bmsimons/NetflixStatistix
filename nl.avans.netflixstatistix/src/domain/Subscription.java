package domain;

import java.util.ArrayList;

public class Subscription {

    private String name;
    private String streetName;
    private String city;
    private int houseNo;
    private String addition;
    private int id;

    private ArrayList<Profile> profiles;

    public Subscription(String name, String streetName, String city, int houseNo, String addition, int id) {
        this.name = name;
        this.streetName = streetName;
        this.city = city;
        this.houseNo = houseNo;
        this.addition = addition;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(int houseNo) {
        this.houseNo = houseNo;
    }

    public String getAddition() {
        return addition;
    }

    public void setAddition(String addition) {
        this.addition = addition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(ArrayList<Profile> profiles) {
        this.profiles = profiles;
    }

    @Override
    public String toString(){
        return name;
    }
}
