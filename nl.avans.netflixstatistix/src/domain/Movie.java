package domain;

public class Movie extends Program{

    private int duration;

    public Movie(int id, String title, String genre, int ageIndication, int duration) {
        super(id, title, genre, ageIndication);

        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
