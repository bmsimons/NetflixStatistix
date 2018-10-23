package domain;

public class WatchedMovie {
    private int profileID;
    private int movieID;
    private int duration;

    public WatchedMovie(int profileID, int movieID, int duration) {
        this.profileID = profileID;
        this.movieID = movieID;
        this.duration = duration;
    }

    public int getProfileID() { return profileID; }

    public void setProfileID(int profileID) { this.profileID = profileID; }

    public int getMovieID() { return movieID; }

    public void setMovieID(int movieID) { this.movieID = movieID; }

    public int getDuration() { return duration; }

    public void setDuration(int duration) { this.duration = duration; }
}
