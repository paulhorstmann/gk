package test;

import lib.liniareDatenstrukturen.List;
import lib.liniareDatenstrukturen.Queue;
import lib.liniareDatenstrukturen.Stack;

import static lib.Eingabe.ConsoleInput.sInput;

public class TodoList {
    Queue<String> zAufgaben = new Queue<>();

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
        if (!pAufgabentext.isEmpty()) zAufgaben.enqueue(pAufgabentext);
        System.out.println();
    }

    public void gibAufgabenAus(){
        if(zAufgaben.isEmpty()) System.out.println("Keine Aufgaben vorhanden \n");
        Queue<String> lAufgaben= new Queue<>();
        while (!zAufgaben.isEmpty()){
            System.out.println(zAufgaben.front());
            lAufgaben.enqueue(zAufgaben.front());
            zAufgaben.dequeue();
        }
        zAufgaben=lAufgaben;
        System.out.println();
    }

    public void löscheAufgabe(){
        löscheAufgabe(sInput("Aufgabe fertig"));
        System.out.println();
    }

    public void löscheAufgabe(String pAufgabentext){
        Queue<String> lAufgaben= new Queue<>();
        while(!zAufgaben.isEmpty()) {
            if(!zAufgaben.front().equals(pAufgabentext)) {
                lAufgaben.enqueue(zAufgaben.front());
                zAufgaben.dequeue();
            }
            zAufgaben.dequeue();
        }
        zAufgaben=lAufgaben;
    }
}
