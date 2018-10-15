package main.java.data;

public class Season {
    private int SerieID;
    private int SeasonID;
    private int SeasonNumber;

    public Season(int seasonID, int serieID, int seasonNumber) {
        this.SerieID = serieID;
        this.SeasonID = seasonID;
        this.SeasonNumber = seasonNumber;
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

    public int getSeasonNumber() {
        return this.SeasonNumber;
    }

    public void setSeasonNumber(int newSeasonNumber) {
        this.SeasonNumber = newSeasonNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (o.getClass() != this.getClass()) {
            return false;
        }

        Season s = (Season) o;

        if (s.getSeasonID() == this.getSeasonID()) {
            return true;
        } else {
            return false;
        }
    }
}