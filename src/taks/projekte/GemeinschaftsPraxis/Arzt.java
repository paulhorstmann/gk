package taks.projekte.GemeinschaftsPraxis;

import lib.liniareDatenstrukturen.Queue;

public class Arzt {

    private String zName;
    private int zAnzahl;
    private Queue<String> zPatienten = new Queue<String>();

    public Arzt(String pName){
        zName = pName;
    }

    public void neuerPatient(String pPatient){
        zPatienten.enqueue(pPatient);
        zAnzahl++;
    }

    public String schliesseBehandlungAb(){
        if(!zPatienten.isEmpty()){
            zAnzahl--;
            String lPatient = zPatienten.front();
            zPatienten.dequeue();
            return lPatient;
        }
        return null;
    }

    public int gibAnzahl() {
        return zAnzahl;
    }

    public String gibName(){
        return zName;
    }

    public Queue<String> gibPatienten(){
        return  zPatienten;
    }

}
