package domain;

import java.util.ArrayList;

public class Series extends Program {

    private Series serieSuggestion;

    private ArrayList<Episode> episodes;

    public Series(int id, String title, String genre, int ageIndication) {
        super(id, title, genre, ageIndication);

        this.episodes = new ArrayList<>();
    }

    public Series getSerieSuggestion(){
        return this.serieSuggestion;
    }

    public void setSerieSuggestion(Series serieSuggestion) {
        this.serieSuggestion = serieSuggestion;
    }

    public ArrayList<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(ArrayList<Episode> episodes) {
        this.episodes = episodes;
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

        Series s = (Series) obj;

        return s.getId() == this.getId();
    }
}
