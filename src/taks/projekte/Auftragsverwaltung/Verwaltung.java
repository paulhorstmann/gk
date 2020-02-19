package taks.projekte.Auftragsverwaltung;

import lib.liniareDatenstrukturen.Queue;

public class Verwaltung {
    Queue<Auftrag> zAuftraege = new Queue<Auftrag>();

    public Verwaltung() {

    }

    public void nimmAuftragEntgegen(String pAuftragsbeschreibung){
        zAuftraege.enqueue(new Auftrag(pAuftragsbeschreibung));
    }

    public Auftrag beendeAuftrag(){
        Auftrag lAuftrag= zAuftraege.front();
        zAuftraege.dequeue();
        return lAuftrag;
    }

    public void uerbernimmAuftraegeVonKollegen(Queue<Auftrag> pAuftraege){
        while(!pAuftraege.isEmpty()) {
            zAuftraege.enqueue(pAuftraege.front());
            pAuftraege.dequeue();
        }
    }

    public Queue<Auftrag> gibAuftraegeAb(int pAnzahl){
        Queue<Auftrag> lAuftraege = new Queue<Auftrag>();
        for (int i = 0; i>pAnzahl; i++){
            lAuftraege.enqueue(zAuftraege.front());
            zAuftraege.dequeue();
        }
        return lAuftraege;
    }
}
