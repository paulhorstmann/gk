package taks.uebungen.sieben.fuenf;

public class Haus {
    private String zAdresse;
    private int zBaujahr;
    private int zFlaeche;

    public Haus(String pAdresse, int pBaujahr, int pFlaeche){
        zAdresse = pAdresse;
        zBaujahr = pBaujahr;
        zFlaeche = pFlaeche;
    }

    public String gibAdresse(){
        return zAdresse;
    }

    public int gibBaujahr(){
        return zBaujahr;
    }

    public int gibFleache(){
        return zFlaeche;
    }

    public void setzeAdresse(String pAdresse){
        zAdresse = pAdresse;
    }

    public void setzeBaujahr(int pBaujahr){
        zBaujahr = pBaujahr;
    }

    public void setzeFleache(int pFlaeche){
        zFlaeche = pFlaeche;
    }
}
