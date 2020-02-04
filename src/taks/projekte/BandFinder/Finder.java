package taks.projekte.BandFinder;

import lib.liniareDatenstrukturen.List;
import lib.Eingabe.ConsoleInput;

import static lib.Eingabe.ConsoleInput.sInput;
import static lib.Eingabe.ConsoleInput.iInput;

public class Finder {
    private List<Band> zBands;

    public Finder(){
         zBands = new List<Band>();
         zBands.append(new Band ("Metallica","Haevy Metal",1975));
         zBands.append(new Band ("Iron Maiden","Haevy Metal",1981));
         zBands.append(new Band ("Judas Priest","Haevy Metal",1969));
         zBands.append(new Band ("AC DC","Rock",1973));
         zBands.append(new Band ("The Rolling Stones","Rock",1962 ));
         zBands.append(new Band ("Pink Floyd","Rock",1965));
         zBands.append(new Band ("Led Zeppelin","Rock",1968));
         zBands.append(new Band ("Queen","Rock",1970));
         zBands.append(new Band ("Public Enemy","Hip Hop",1982));
         zBands.append(new Band ("Beastie Boys","Hip Hop",1981));
         zBands.append(new Band ("Run-D.M.C.","Hip Hop",1982));
         zBands.append(new Band ("Depeche Mode","Electro",1980));
         zBands.append(new Band ("Twenty One Pilots","Electro",2009));
         zBands.append(new Band ("Kraftwerk","Electro",1970));
         zBands.append(new Band ("Kraftwerk","Electro",1970));
         zBands.append(new Band ("The Beatles","Pop",1957));
         zBands.append(new Band ("ABBA","Pop",1972));
         zBands.append(new Band ("The Blues Brothers","Pop",1980));
         zBands.append(new Band ("The Animals","Rock",1962));
         contoller();
    }

    public void sucheBandAusgabe(){
        String lSuchwort = sInput("Suchewort");
        Band lBand;
        boolean lGefunden = false;
        zBands.toFirst();
        System.out.println();
        while(zBands.hasAccess()){
            lBand = zBands.getContent();
            if(lBand.gibName().equals(lSuchwort) || lBand.gibStil().equals(lSuchwort)){
                gibBandAus(lBand);
                lGefunden = true;
            }
            else{
                try{
                    int lJahr = Integer.parseInt(lSuchwort.trim());
                    if(lBand.gibJahr() == lJahr){
                        gibBandAus(lBand);
                        lGefunden = true;
                    }
                }
                catch (NumberFormatException nfe){}
            }
            zBands.next();
        }
        if (!lGefunden) System.out.println("Es konnte keine Band gefunden werden");
    }

    public void feugeBandHinzu(){
        zBands.toLast();
        System.out.println("Band hinzufuegen:");
        Band lBand = new Band (sInput("Name"),sInput("Style"),iInput("Jahr"));
        if(sInput("Willst du speichern \n").equals("ja")){
            zBands.insert(lBand);
            System.out.println("[Info] Band wurde erfolgreich hinzugefuegt");
        } else System.out.println("[Info] Vorgang wurde abgebrochen");
    }

    public void contoller(){
        boolean run = true;
        String Befehl;
        while (run){
            System.out.println();
            Befehl = sInput("Dein Befehl:");
            Befehl = Befehl.toLowerCase();
            switch(Befehl){
                case "s":
                case "suche band": sucheBandAusgabe();break;
                case "band hinzufuegen": feugeBandHinzu();break;
                case "Band loeschen": feugeBandHinzu();break;
                case  "exit": run = false; break;
                case "":break;
                default: System.out.println("{Error} Der Befehl konnte nicht gefunden weden.");
            }

        }
    }

    public void gibBandAus(Band pBand){
        System.out.println("\nName: " + pBand.gibName());
        System.out.println("Stil: " + pBand.gibStil());
        System.out.println("Jahr: " + pBand.gibJahr() + "");
    }
}
