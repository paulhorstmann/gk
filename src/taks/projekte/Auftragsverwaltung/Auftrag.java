package taks.projekte.Auftragsverwaltung;

public class Auftrag {
    private String zAuftragsbeschreibung;

    public Auftrag(String pAuftragsbeschreibung) {
        zAuftragsbeschreibung = pAuftragsbeschreibung;
    }

    public String gibAuftragsbeschreibung() {
        return zAuftragsbeschreibung;
    }
}
