package taks.projekte.Betriebsystem;

import lib.liniareDatenstrukturen.Queue;

public class System {
    Queue<Anwendung> zAnwendungen = new Queue<Anwendung>();

    public void nimmAnwendungAuf(int pID,String pDateiname) {
        zAnwendungen.enqueue(new Anwendung(pID, pDateiname));
    }

    public void beendeZugriff(){
        zAnwendungen.dequeue();
    }

    public void loescheAnwendung(int pID){
        Queue<Anwendung> lAnwendungen = new Queue<Anwendung>();
        while(!zAnwendungen.isEmpty()){
            if (zAnwendungen.front().gibID() > pID) {
                lAnwendungen.enqueue(zAnwendungen.front());
                zAnwendungen.dequeue();
            }
        }
        zAnwendungen = lAnwendungen;
    }
}
