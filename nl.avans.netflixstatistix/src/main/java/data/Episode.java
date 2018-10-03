package main.java.data;

public class Episode {
    private int SeasonID;
    private int EpisodeID;
    private String ShortDescription;
    private int SeasonNumber;
    private int EpisodeNumber;

    public Episode(int seasonID, int episodeID, String shortDescription, int seasonNumber, int episodeNumber) {
        this.SeasonID = seasonID;
        this.EpisodeID = episodeID;
        this.ShortDescription = shortDescription;
        this.SeasonNumber = seasonNumber;
        this.EpisodeNumber = episodeNumber;
    }

    public int getSeasonID() {
        return this.SeasonID;
    }

    public void setSeasonID(int newSeasonID) {
        this.SeasonID = newSeasonID;
    }

    public int getEpisodeID() {
        return this.EpisodeID;
    }

    public void setEpisodeID(int newEpisodeID) {
        this.EpisodeID = newEpisodeID;
    }

    public String getShortDescription() {
        return this.ShortDescription;
    }

    public void setShortDescription(String newShortDescription) {
        this.ShortDescription = newShortDescription;
    }

    public int getSeasonNumber() {
        return this.SeasonNumber;
    }

    public void setSeasonNumber(int newSeasonNumber) {
        this.SeasonNumber = newSeasonNumber;
    }

    public int getEpisodeNumber() {
        return this.EpisodeNumber;
    }

    public void setEpisodeNumber(int newEpisodeNumber) {
        this.EpisodeNumber = newEpisodeNumber;
    }
}
