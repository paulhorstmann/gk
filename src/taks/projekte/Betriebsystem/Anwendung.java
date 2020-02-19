package taks.projekte.Betriebsystem;

public class Anwendung {
    private int zID;
    private String zDateinahme;

    public Anwendung(int pID, String pDateinahme) {
        zID = pID;
        zDateinahme = pDateinahme;
    }

    public int gibID() {
        return zID;
    }

    public String gibDateinahme() {
        return zDateinahme;
    }
}
