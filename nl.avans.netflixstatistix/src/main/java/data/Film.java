package main.java.data;

public class Film{
    private int ProgramID;
    private int FilmID;
    private int Duration;

    public Film(int filmID, int programID, int duration) {
        this.ProgramID = programID;
        this.FilmID = filmID;
        this.Duration = duration;
    }

    public int getProgramID() {
        return this.ProgramID;
    }

    public void setProgramID(int newProgramID) {
        this.ProgramID = newProgramID;
    }

    public int getFilmID() {
        return this.FilmID;
    }

    public void setFilmID(int newFilmID) {
        this.FilmID = newFilmID;
    }

    public int getDuration() {
        return this.Duration;
    }

    public void setDuration(int newDuration) {
        this.Duration = newDuration;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (o.getClass() != this.getClass()) {
            return false;
        }

        Film f = (Film) o;

        if (f.getFilmID() == this.getFilmID()) {
            return true;
        } else {
            return false;
        }
    }
}