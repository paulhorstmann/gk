import taks.projekte.BandFinder.Finder;
import taks.projekte.Leherschreibtisch.Schreibtisch;
import test.TodoList;

public class Main {
    public static void main(String[] args) {
        Schreibtisch lHam = new Schreibtisch();
        Schreibtisch lLan = new Schreibtisch();
        lHam.neueKlausur("Malte","Englisch Gk4");
        lHam.neueKlausur("Herbert","Englisch Gk4");
        lHam.neueKlausur("Norbert","Englisch Gk4");
        lHam.neueKlausur("Max","Englisch Gk4");
        lHam.neueKlausur("Herbert","Englisch Gk4");
        lHam.naechsteKlausur();
        lLan.neueKlausur("Bert", "Arteistische Religion Lk3");
        lLan.neueKlausur("Marten", "Arteistische Religion Lk3");
        lLan.neueKlausur("Ernie", "Arteistische Religion Lk3");
        lLan.neueKlausur("Karl", "Arteistische Religion Lk3");
        lLan.uebernimmKlausur(lHam);
     }
}
