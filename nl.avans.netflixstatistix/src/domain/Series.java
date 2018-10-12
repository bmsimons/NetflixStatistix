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
}
