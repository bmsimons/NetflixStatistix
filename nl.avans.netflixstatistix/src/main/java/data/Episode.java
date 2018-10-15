package main.java.data;

public class Episode {
    private int EpisodeID;
    private int SerieID;
    private int SeasonID;
    private String ShortDescription;
    private int EpisodeNumber;

    public Episode(int episodeID, int serieID, int seasonID, String shortDescription, int episodeNumber) {
        this.EpisodeID = episodeID;
        this.SerieID = serieID;
        this.SeasonID = seasonID;
        this.ShortDescription = shortDescription;
        this.EpisodeNumber = episodeNumber;
    }

    public int getEpisodeID() {
        return this.EpisodeID;
    }

    public void setEpisodeID(int newEpisodeID) {
        this.EpisodeID = newEpisodeID;
    }

    public int getSerieID() {
        return this.SerieID;
    }

    public void setSerieID(int newSerieID) {
        this.SerieID = newSerieID;
    }

    public int getSeasonID() {
        return this.SeasonID;
    }

    public void setSeasonID(int newSeasonID) {
        this.SeasonID = newSeasonID;
    }

    public String getShortDescription() {
        return this.ShortDescription;
    }

    public void setShortDescription(String newShortDescription) {
        this.ShortDescription = newShortDescription;
    }

    public int getEpisodeNumber() {
        return this.EpisodeNumber;
    }

    public void setEpisodeNumber(int newEpisodeNumber) {
        this.EpisodeNumber = newEpisodeNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (o.getClass() != this.getClass()) {
            return false;
        }

        Episode e = (Episode) o;

        if (e.getEpisodeID() == this.getEpisodeID()) {
            return true;
        } else {
            return false;
        }
    }
}
