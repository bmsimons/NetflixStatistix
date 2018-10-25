package main.java.data;

public class WatchedMovie {
    private int WatchedMovieID;
    private int ProfileID;
    private int FilmID;

    public WatchedMovie(int watchedMovieID, int profileID, int filmID) {
        this.WatchedMovieID = watchedMovieID;
        this.ProfileID = profileID;
        this.FilmID = filmID;
    }

    public int getWatchedMovieID() {
        return this.WatchedMovieID;
    }

    public int getProfileID() {
        return this.ProfileID;
    }

    public int getFilmID() {
        return this.FilmID;
    }

    public void setWatchedMovieID(int watchedMovieID) {
        this.WatchedMovieID = watchedMovieID;
    }

    public void setProfileID(int profileID) {
        this.ProfileID = profileID;
    }

    public void setFilmID(int filmID) {
        this.FilmID = filmID;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (o.getClass() != this.getClass()) {
            return false;
        }

        WatchedMovie w = (WatchedMovie) o;

        if (w.getWatchedMovieID() == this.getWatchedMovieID()) {
            return true;
        } else {
            return false;
        }
    }
}
