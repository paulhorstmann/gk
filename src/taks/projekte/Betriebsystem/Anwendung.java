package taks.projekte.Betriebsystem;

public class Anwendung {
    private int zID;
    private String zDateiname;

    public Anwendung(int pID, String pDateiname) {
        zID = pID;
        zDateiname = pDateiname;
    }

    public int gibID() {
        return zID;
    }

    public String gibDateiname() {
        return zDateiname;
    }
}
+