package main.java.data;

public class WatchedEpisode implements ITable {
    private int WatchedEpisodeID;
    private int ProfileID;
    private int EpisodeID;

    public WatchedEpisode(int watchedEpisodeID, int profileID, int episodeID) {
        this.WatchedEpisodeID = watchedEpisodeID;
        this.ProfileID = profileID;
        this.EpisodeID = episodeID;
    }

    public int getWatchedEpisodeID() {
        return this.WatchedEpisodeID;
    }

    public int getProfileID() {
        return this.ProfileID;
    }

    public int getEpisodeID() {
        return this.EpisodeID;
    }

    public void setWatchedEpisodeID(int watchedEpisodeID) {
        this.WatchedEpisodeID = watchedEpisodeID;
    }

    public void setProfileID(int profileID) {
        this.ProfileID = profileID;
    }

    public void setEpisodeID(int episodeID) {
        this.EpisodeID = episodeID;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (o.getClass() != this.getClass()) {
            return false;
        }

        WatchedEpisode w = (WatchedEpisode) o;

        if (w.getWatchedEpisodeID() == this.getWatchedEpisodeID()) {
            return true;
        } else {
            return false;
        }
    }
}
