package taks.projekte.alternativeLineareDatenstrukturen;

import lib.liniareDatenstrukturen.Element;
import lib.liniareDatenstrukturen.List;

public class Queue2<ContentType> extends List<ContentType> {
    public Queue2(){
        super();
    }

    public ContentType front() {
        if (isEmpty()) return null;
        else return zKopf.gibNachfolger().gibInhalt();
    }

    public void dequeue() {
        if (!isEmpty())
            zKopf.setzeNachfolger(zKopf.gibNachfolger().gibNachfolger());
    }

    public void enqueue(ContentType pContent) {
        if (pContent != null) {
            Element<ContentType> lNeu = new Element<ContentType>();
            zEnde.setzeInhalt(pContent);
            zEnde.setzeNachfolger(lNeu);
            zEnde = lNeu;
        }
    }
}
