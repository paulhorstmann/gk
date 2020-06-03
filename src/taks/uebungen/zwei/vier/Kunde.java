package taks.uebungen.zwei.vier;

import lib.untils.ComparableContent;

public class Kunde implements ComparableContent<Kunde> {
    private String zName;
    private int zKundennummer;
    private String zAdresse;
    private double zOffenerBetrag;

    public Kunde(String pName, String pAdresse){
        zName = pName;
        zAdresse = pAdresse;
    }

    public Kunde(String pName, String pAdresse, int pKundenummer){
        zName = pName;
        zAdresse = pAdresse;
        zKundennummer = pKundenummer;
    }

    public void alleKundenRechnungenBegleichen(){
        zOffenerBetrag = 0;
    }

    public void neueRechnungAnschreiben(double pBetrag){
        zOffenerBetrag = zOffenerBetrag - pBetrag;
    }

    public void RechnungBegleichen(double pBetrag){
        zOffenerBetrag = zOffenerBetrag + pBetrag;
    }

    public void setzeAdresse(String pAdresse){
        zAdresse = pAdresse;
    }

    public void setzeName(String pName){
        zName = pName;
    }

    public void setzeOffenerBetrag(double pBetrag){
        zOffenerBetrag = pBetrag;
    }

    public String gibAdresse(){
        return zAdresse;
    }

    public String gibName(){
        return zName;
    }

    public int gibKundennummer() {
        return zKundennummer;
    }

    public String gibErinnerungsschreiben(){
        System.out.println("Sehr geehrter Frau/Herr " + zName + ", sie haben noch einen Betrag von " + zOffenerBetrag + " Euro zu begleichen");
        return "Sehr geehrter Frau/Herr " + zName + ", sie haben noch einen Betrag von " + zOffenerBetrag + " Euro zu begleichen";
    }

    public double gibOffenerBetrag(){
        return zOffenerBetrag;
    }

    @Override
    public boolean isEqual(Kunde pComparableContent) {
        return pComparableContent.gibName().equals(zName);
    }

    @Override
    public boolean isGreater(Kunde pComparableContent) {
        return pComparableContent.gibName().compareTo(zName) < 0;
    }

    @Override
    public boolean isLess(Kunde pComparableContent) {
        return pComparableContent.gibName().compareTo(zName) > 0;
    }
}
