package taks.projekte.GemeinschaftsPraxis;

import lib.liniareDatenstrukturen.List;
import lib.liniareDatenstrukturen.Queue;

public class Gemeinschaftspraxis {
    private List<Arzt> zAerzte = new List<Arzt>();

    public void nimmArztAuf(String pArzt) {
        zAerzte.toFirst();
        while (zAerzte.hasAccess()) {
            if (zAerzte.getContent().gibName().equals(pArzt)) {
                System.out.println("Der Arzt " + pArzt + " ist ");
            }
            zAerzte.next();
        }
        zAerzte.append(new Arzt(pArzt));
        System.out.println("Der Arzt" + pArzt + "ist jetzt anwesend");
    }

    public void verabschiedeArzt(String pArzt) {
        zAerzte.toFirst();
        while (zAerzte.hasAccess()) {
            if (zAerzte.getContent().gibName().equals(pArzt)) {
                Queue<String> lPatient = zAerzte.getContent().gibPatienten();
                zAerzte.remove();
                while (!lPatient.isEmpty()) {
                    nimmArztAuf(lPatient.front());
                    lPatient.dequeue();
                }
                System.out.println("Der Arzt " + pArzt + " ist jetzt Abwesend");
                return;
            }
            zAerzte.next();
        }
        System.out.println("Der Arzt " + pArzt + " ist nicht anwesend gewesen");
    }

    public void nimmPatientenAuf(String pPatient) {

    }

    public void gibAlleWarteschlangenAus() {
        zAerzte.toFirst();
        while (zAerzte.hasAccess()) {
            Queue<String> lPatienten = zAerzte.getContent().gibPatienten();
            while (lPatienten.isEmpty()) {
                lPatienten.enqueue(zAerzte.getContent().gibPatienten().front());
                zAerzte.getContent().gibPatienten().dequeue();
            }
        }
    }

    public void schliesseBehandlungAb() {

    }

    public void verabschiebeArzt() {

    }
}
