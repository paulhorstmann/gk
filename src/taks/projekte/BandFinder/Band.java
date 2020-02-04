package taks.projekte.BandFinder;

public class Band {
    private String zName;
    private String zStil;
    private int zJahr;

    public Band (String pName, String pStil, int pJahr)
    {
        zName = pName;
        zStil = pStil;
        zJahr = pJahr;
    }

    public String gibName()
    {
        return zName;
    }

    public String gibStil()
    {
        return zStil;
    }

    public int gibJahr()
    {
        return zJahr;
    }
}
