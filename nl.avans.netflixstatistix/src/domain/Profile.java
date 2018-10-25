package domain;

import java.util.ArrayList;
import java.util.List;

public class Profile {
    private String profileName;
    private int age;
    private int id;

    private ArrayList<Program> programsWatched;

    public Profile(String profileName, int age, int id) {
        this.profileName = profileName;
        this.age = age;
        this.id = id;

        programsWatched = new ArrayList<>();
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addProgram(Program program){
        this.programsWatched.add(program);
    }

    public List<Program> getWatchedPrograms(){
        return this.programsWatched;
    }
}
