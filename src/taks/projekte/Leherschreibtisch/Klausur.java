package taks.projekte.Leherschreibtisch;

public class Klausur {
    private String zName;
    private String zKurs;

    public Klausur(String pName,String pKurs){
        zName = pName;
        zKurs = pKurs;
    }

    public String gibKurs() {
        return zKurs;
    }

    public String gibName() {
        return zName;
    }

    public void setzeKurs(String pKurs) {
        this.zKurs = pKurs;
    }

    public void setzeName(String pName) {
        this.zName = zName;
    }
}

