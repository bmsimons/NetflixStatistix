package main.java.data;

public class Account implements ITable {
    private int SubscriptionID;
    private String Name;
    private String Email;
    private String Password;
    private String Street;
    private String Postcode;
    private int HouseNumber;
    private String City;

    public Account(int subscriptionID, String name, String email, String password, String street, String postcode, int houseNumber, String city) {
        this.SubscriptionID = subscriptionID;
        this.Name = name;
        this.Email = email;
        this.Password = password;
        this.Street = street;
        this.Postcode = postcode;
        this.HouseNumber = houseNumber;
        this.City = city;
    }

    public int getSubscriptionID() {
        return this.SubscriptionID;
    }

    public String getName() {
        return this.Name;
    }

    public String getEmail() {
        return this.Email;
    }

    public String getPassword() {
        return this.Password;
    }

    public String getStreet() {
        return this.Street;
    }

    public String getPostcode() {
        return this.Postcode;
    }

    public int getHouseNumber() {
        return this.HouseNumber;
    }

    public String getCity() {
        return this.City;
    }

    public void setSubscriptionID(int subscriptionID) {
        this.SubscriptionID = subscriptionID;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public void setStreet(String street) {
        this.Street = street;
    }

    public void setPostcode(String postcode) {
        this.Postcode = postcode;
    }

    public void setHouseNumber(int houseNumber) {
        this.HouseNumber = houseNumber;
    }

    public void setCity(String city) {
        this.City = city;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (o.getClass() != this.getClass()) {
            return false;
        }

        Account a = (Account) o;

        if (a.getSubscriptionID() == this.getSubscriptionID()) {
            return true;
        } else {
            return false;
        }
    }
}
