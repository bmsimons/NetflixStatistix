package domain;

public enum Language {

    EN("English"),
    NL("Nederlands"),
    DE("Deutsch"),
    FR("Français"),
    ES("Español"),
    RU("Pусский");

    private String language;

    Language(String language) {
        this.language = language;
    }

    public String getLanguage(){
        return this.language;
    }
}
