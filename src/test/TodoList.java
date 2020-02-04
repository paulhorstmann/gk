package test;

import lib.liniareDatenstrukturen.List;

import static lib.Eingabe.ConsoleInput.sInput;

public class TodoList {
    List<String>  zAufgaben = new List<String>();

    public TodoList(){
        System.out.println("Todo liste wurde gestartet \n");
        fuegeAufgabeHinzu();
        fuegeAufgabeHinzu();
        gibAufgabenAus();
        löscheAufgabe();
        gibAufgabenAus();
    }

    public void fuegeAufgabeHinzu(){
        fuegeAufgabeHinzu(sInput("Neue Aufgabe"));
    }

    public void fuegeAufgabeHinzu(String pAufgabentext){
        if (!pAufgabentext.equals("")) zAufgaben.append(new String("Hallo"));
        System.out.println();
    }

    public void gibAufgabenAus(){
        zAufgaben.toFirst();
        if(zAufgaben.isEmpty()) System.out.println("Keine Aufgaben vorhanden \n");
        while(zAufgaben.hasAccess()) {
            System.out.println(zAufgaben.getContent());
            zAufgaben.next();
        }
        System.out.println();
    }

    public void löscheAufgabe(){
        löscheAufgabe(sInput("Aufgabe fertig"));
        System.out.println();
    }

    public void löscheAufgabe(String pAufgabentext){
        zAufgaben.toFirst();
        while(zAufgaben.hasAccess()){
            if(zAufgaben.getContent().equals(pAufgabentext)){
                zAufgaben.remove();
                return;
            }
            zAufgaben.next();
        }
    }
}
