package lib.liniareDatenstrukturen;

public class Queue<ContentType> {
    private Element<ContentType> zKopf;
    private Element<ContentType> zEnde;

    public Queue() {
        zKopf = new Element<ContentType>();
        zEnde = new Element<ContentType>();
        zKopf.setzeNachfolger(zEnde);
    }

    public boolean isEmpty() {
        return zKopf.gibNachfolger() == zEnde;
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