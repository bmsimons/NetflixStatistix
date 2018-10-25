package domain;

public abstract class Program {
    private int id;
    private String title;
    private String genre;
    private int ageIndication;

    private Language language;

    public Program(int id, String title, String genre, int ageIndication) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.ageIndication = ageIndication;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getAgeIndication() {
        return ageIndication;
    }

    public void setAgeIndication(int ageIndication) {
        this.ageIndication = ageIndication;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
