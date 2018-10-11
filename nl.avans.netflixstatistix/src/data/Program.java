package data;

public class Program implements ITable {
    private int ProgramID;
    private String Title;
    private String Genre;
    private String Language;
    private String ShortDescription;
    private int MinAge;

    public Program(int programID, String title, String genre, String language, String shortDescription, int minAge) {
        this.ProgramID = programID;
        this.Title = title;
        this.Genre = genre;
        this.Language = language;
        this.ShortDescription = shortDescription;
        this.MinAge = minAge;
    }

    public int getProgramID() {
        return this.ProgramID;
    }

    public void setProgramID(int newProgramID) {
        this.ProgramID = newProgramID;
    }

    public String getTitle() {
        return this.Title;
    }

    public void setTitle(String newTitle) {
        this.Title = newTitle;
    }

    public String getGenre() {
        return this.Genre;
    }

    public void setGenre(String newGenre) {
        this.Genre = newGenre;
    }

    public String getLanguage() {
        return this.Language;
    }

    public void setLanguage(String newLanguage) {
        this.Language = newLanguage;
    }

    public String getShortDescription() {
        return this.ShortDescription;
    }

    public void setShortDescription(String newShortDescription) {
        this.ShortDescription = newShortDescription;
    }

    public int getMinAge() {
        return this.MinAge;
    }

    public void setMinAge(int newMinAge) {
        this.MinAge = newMinAge;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (o.getClass() != this.getClass()) {
            return false;
        }

        Program p = (Program) o;

        if (p.getProgramID() == this.getProgramID()) {
            return true;
        } else {
            return false;
        }
    }
}
