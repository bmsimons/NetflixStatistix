package domain;

public class WatchedEpisode {
    private int profileID;
    private int episodeID;
    private int duration;

    public WatchedEpisode(int profileID, int episodeID, int duration) {
        this.profileID = profileID;
        this.episodeID = episodeID;
        this.duration = duration;
    }

    public int getProfileID() { return profileID; }

    public void setProfileID(int profileID) { this.profileID = profileID; }

    public int getEpisodeID() { return episodeID; }

    public void setEpisodeID(int episodeID) { this.episodeID = episodeID; }

    public int getDuration() { return duration; }

    public void setDuration(int duration) { this.duration = duration; }
}
