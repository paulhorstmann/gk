package taks.projekte.Leherschreibtisch;

import lib.liniareDatenstrukturen.Element;
import lib.liniareDatenstrukturen.Stack;

public class Schreibtisch {
    Stack<Klausur> zKlausuren;
    public Schreibtisch() {
        zKlausuren = new Stack<Klausur>();
    }

    public void hinzufuegen(String pName, String pKurs) {
        Klausur lNeu = new Klausur(pName, pKurs);
        zKlausuren.push(lNeu);
    }

    public Stack<Klausur> korrigieren(int pAnzahl) {
        Stack<Klausur> lStack = new Stack<Klausur>();
        for(int i = 0; i < pAnzahl; i++) {
            if(zKlausuren.top().equals(null)) {
                return lStack;
            }
            lStack.push(zKlausuren.top());
            zKlausuren.pop();
        }
        return lStack;
    }

    public void fuelleStapelAuf(Stack<Klausur> pKlausuren) {
        while(!pKlausuren.isEmpty()) {
            zKlausuren.push(pKlausuren.top());
            pKlausuren.pop();
        }
    }

    public int wieVieleAusKurs(String pKurs) {
        Stack<Klausur> lStack = new Stack<Klausur>();
        int lZaehler = 0;
        while(!zKlausuren.isEmpty()) {
            lStack.push(zKlausuren.top());
            zKlausuren.pop();
            if(lStack.top().gibKurs().equals(pKurs))
                lZaehler++;
        }
        while(!lStack.isEmpty()) {
            zKlausuren.push(lStack.top());
            lStack.pop();
        }
        return lZaehler;
    }
}
