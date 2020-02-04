package lib.liniareDatenstrukturen;

public class Stack<ContentType>
{
    private Element<ContentType> zEnde;

    public Stack()
    {
        zEnde = new Element<ContentType>();
    }

    public boolean isEmpty()
    {
        return zEnde.gibVorgaenger() == null;
    }

    public void push (ContentType pContent)
    {
        if (pContent != null)
        {
            Element<ContentType> lNeu = new Element<ContentType>();
            lNeu.setzeInhalt(pContent);
            lNeu.setzeVorgaenger(zEnde.gibVorgaenger());
            zEnde.setzeVorgaenger(lNeu);
        }
    }

    public void pop()
    {
        if (! isEmpty())
            zEnde.setzeVorgaenger(zEnde.gibVorgaenger().gibVorgaenger());
    }

    public ContentType top()
    {
        if (isEmpty()) return null;
        else return zEnde.gibVorgaenger().gibInhalt();
    }
}
