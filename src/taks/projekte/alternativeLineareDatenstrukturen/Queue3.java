package taks.projekte.alternativeLineareDatenstrukturen;

import lib.liniareDatenstrukturen.List;

public class Queue3<ContentType> {
    List<ContentType> lListe = new List<ContentType>();

    public ContentType front() {
        if (lListe.isEmpty()) return null;
        else {
            lListe.toFirst();
            return lListe.getContent();
        }
    }

    public void dequeue() {
        if (!lListe.isEmpty())
            lListe.toFirst();
            lListe.remove();
    }

    public void enqueue(ContentType pContent) {
        if (pContent != null) {
            lListe.append(pContent);
        }
    }

}
