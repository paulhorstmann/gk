package taks.projekte.KundenverwaltungBaum;

import lib.nonlinieareDatenstrukturen.BinarySearchTree;
import taks.uebungen.zwei.vier.Kunde;

public class KundenVerwaltungBaum {
    private BinarySearchTree<Kunde> zBaum = new BinarySearchTree<Kunde>();
    private int zKundenanzahl;


    public boolean neuerKunde(String pName, String pAdresse) {
        Kunde lKunde = new Kunde(pName, pAdresse);
        if (zBaum.search(lKunde) == null) {
            zBaum.insert(lKunde);
            zKundenanzahl++;
            System.out.println(pName + " wurde angelegt");
            return true;
        }
        System.out.println(pName + " ist schon vorhanden");
        return false;
    }

    public boolean loescheKunden(String pName) {
        Kunde lKunde = sucheKundenAnhandDesNamens(pName);
        if (lKunde != null) {
            zBaum.remove(lKunde);
            System.out.println(pName + " wurde gelöscht");
        }
        System.out.println(pName + " ist nicht vorhanden");
        return false;
    }

    public String gibAdresseAnhandDesNamens(String pName) {
        return sucheKundenAnhandDesNamens(pName).gibAdresse();
    }

    public Kunde sucheKundenAnhandDesNamens(String pName) {
        return zBaum.search(new Kunde(pName, ""));
    }

    public int gibKundenanzahl() {
        return zKundenanzahl;
    }
}