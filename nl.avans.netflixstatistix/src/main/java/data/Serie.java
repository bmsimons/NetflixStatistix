package main.java.data;

public class Serie implements ITable {
    private int ProgramID;
    private int SerieID;

    public Serie(int serieID, int programID) {
        this.ProgramID = programID;
        this.SerieID = serieID;
    }

    public int getProgramID() {
        return this.ProgramID;
    }

    public void setProgramID(int newProgramID) {
        this.ProgramID = newProgramID;
    }

    public int getSerieID() {
        return this.SerieID;
    }

    public void setSerieID(int newSerieID) {
        this.SerieID = newSerieID;
    }
}
