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

    @Override
    public int hashCode() {
        return this.getId().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        Movie m = (Movie) obj;

        return m.getId() == this.getId();
    }
}
