import lib.nonlinieareDatenstrukturen.BinarySearchTreeS;
import taks.projekte.KundenverwaltungBaum.KundenVerwaltungBaum;
import taks.uebungen.zwei.vier.Kunde;
import test.TodoList;

public class Main {
    public static void main(String[] args) {
        KundenVerwaltungBaum lKv = new KundenVerwaltungBaum();
        lKv.neuerKunde("Paul", "Pflugstraße 7");
        lKv.neuerKunde("Markus", "Herbertalle 4");
        lKv.neuerKunde("Maxim", "Hubenweg 2");
        lKv.neuerKunde("Joachim", "Alter Wall 20");
        lKv.neuerKunde("Maik", "Hoheluftchaussee 50");
        System.out.println(lKv.gibAdresseAnhandDesNamens("Maik"));
    }
}