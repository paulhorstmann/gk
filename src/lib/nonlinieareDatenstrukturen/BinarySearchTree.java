package lib.nonlinieareDatenstrukturen;

import lib.untils.ComparableContent;

public class BinarySearchTree<ContentType extends ComparableContent<ContentType>> {
    private ContentType zInhalt;
    private BinarySearchTree<ContentType> zLinkerSohn;
    private BinarySearchTree<ContentType> zRechterSohn;

    public BinarySearchTree() {
        zInhalt = null;
    }

    public BinarySearchTree(ContentType pContent) {
        zInhalt = pContent;
    }

    public BinarySearchTree(ContentType pContent, BinarySearchTree pLinkerSohn, BinarySearchTree pRechterSohn) {
        zInhalt = pContent;
    }

    public boolean isEmpty() {
        return zInhalt == null;
    }

    public void insert(ContentType pContent) {
        if (isEmpty()) {
            zInhalt = pContent;
            zLinkerSohn = new BinarySearchTree<ContentType>();
            zRechterSohn = new BinarySearchTree<ContentType>();
        } else if (pContent.isLess(zInhalt)) zLinkerSohn.insert(pContent);
        else if (zInhalt.isLess(pContent)) zRechterSohn.insert(pContent);
    }

    public void insertIterativ(ContentType pContent) {
        if (isEmpty()) {
            zInhalt = pContent;//Wurzel mit Inhalt fullen
        } else {
            BinarySearchTree<ContentType> lAktuell = this;
            boolean lFertig = false;
            while (!lFertig) {
                if (lAktuell.zInhalt.isEqual(pContent))//gefunden!
                {
                    lFertig = true;//sonst nichts zu tun
                } else if (pContent.isLess(lAktuell.zInhalt))//links halten ...
                {
                    if (lAktuell.zLinkerSohn != null)//linker Sohn existiert?
                    {
                        lAktuell = lAktuell.zLinkerSohn;
                    } else {
                        lAktuell.zLinkerSohn = new BinarySearchTree<ContentType>();
                        lAktuell.zLinkerSohn.zInhalt = pContent;
                        lFertig = true;//Abbrechen
                    }
                } else//rechts halten ...
                {
                    if (lAktuell.zRechterSohn != null)//rechter Sohn existiert?
                    {
                        lAktuell = lAktuell.zRechterSohn;
                    } else {
                        lAktuell.zRechterSohn = new BinarySearchTree<ContentType>();
                        lAktuell.zRechterSohn.zInhalt = pContent;
                        lFertig = true;//Abbrechen
                    }
                }
            }
        }
    }

    public ContentType search(ContentType pContent) {
        if (isEmpty()) return null;
        else if (pContent.isLess(zInhalt)) return zLinkerSohn.search(pContent);
        else if (zInhalt.isLess(pContent)) return zRechterSohn.search(pContent);
        else return zInhalt;
    }

    private ContentType search(ContentType pContent, BinarySearchTree<ContentType> pKnoten) {
        if (pContent.isLess(pKnoten.zInhalt)) {
            if (pKnoten.zLinkerSohn != null) return search(pContent, pKnoten.zLinkerSohn);
            else return null;
        } else if (pKnoten.zInhalt.isLess(pContent)) {
            if (pKnoten.zRechterSohn != null) return search(pContent, pKnoten.zRechterSohn);
            else return null;
        } else return pKnoten.zInhalt;
    }

    public void remove(ContentType pContent) {
        if (!isEmpty()) {
            if (zInhalt.isEqual(pContent)) {
                if (zLinkerSohn == null && zRechterSohn == null)
                    zInhalt = null;
                else if (zLinkerSohn != null && zRechterSohn == null) {
                    zInhalt = zLinkerSohn.getContent();
                    BinarySearchTree<ContentType> lLinks = zLinkerSohn.getLeftTree();
                    BinarySearchTree<ContentType> lRechts = zLinkerSohn.getRightTree();
                    zLinkerSohn = lLinks;
                    zRechterSohn = lRechts;
                } else if (zLinkerSohn == null && zRechterSohn != null) {
                    zInhalt = zRechterSohn.getContent();
                    BinarySearchTree<ContentType> lLinks = zRechterSohn.getLeftTree();
                    BinarySearchTree<ContentType> lRechts = zRechterSohn.getRightTree();
                    zLinkerSohn = lLinks;
                    zRechterSohn = lRechts;
                } else remove(pContent, this);
            } else remove(pContent, this);
        }
    }

    private void remove(ContentType pContent, BinarySearchTree<ContentType> pKnoten) {
        if (pContent.isLess(pKnoten.zInhalt)) {
            if (pKnoten.zLinkerSohn != null) {
                if (pKnoten.zLinkerSohn.zInhalt.isEqual(pContent)) {
                    if (pKnoten.zLinkerSohn.zLinkerSohn == null)
                        pKnoten.zLinkerSohn = pKnoten.zLinkerSohn.zRechterSohn;
                    else if (pKnoten.zLinkerSohn.zRechterSohn == null)
                        pKnoten.zLinkerSohn = pKnoten.zLinkerSohn.zLinkerSohn;
                    else remove(pContent, pKnoten.zLinkerSohn);
                } else remove(pContent, pKnoten.zLinkerSohn);
            }
        } else if (pKnoten.zInhalt.isLess(pContent)) {
            if (pKnoten.zRechterSohn != null) {
                if (pKnoten.zRechterSohn.zInhalt.isEqual(pContent)) {
                    if (pKnoten.zRechterSohn.zLinkerSohn == null)
                        pKnoten.zRechterSohn = pKnoten.zRechterSohn.zRechterSohn;
                    else if (pKnoten.zRechterSohn.zRechterSohn == null)
                        pKnoten.zRechterSohn = pKnoten.zRechterSohn.zLinkerSohn;
                    else remove(pContent, pKnoten.zRechterSohn);
                } else remove(pContent, pKnoten.zRechterSohn);
            }
        } else {
            BinarySearchTree<ContentType> lVdsN = gibVaterDesSymmetrischenNachfolgers(pKnoten);
            if (pKnoten == lVdsN) {
                pKnoten.zInhalt = pKnoten.zRechterSohn.zInhalt;
                pKnoten.zRechterSohn = pKnoten.zRechterSohn.zRechterSohn;
            } else {
                pKnoten.zInhalt = lVdsN.zLinkerSohn.zInhalt;
                lVdsN.zLinkerSohn = lVdsN.zLinkerSohn.zRechterSohn;
            }
        }
    }

    private BinarySearchTree<ContentType> gibVaterDesSymmetrischenNachfolgers(BinarySearchTree<ContentType> pKnoten) {
        if (pKnoten.zRechterSohn.zLinkerSohn == null) return pKnoten;
        else {
            BinarySearchTree<ContentType> lAktuell = pKnoten.zRechterSohn;
            while (lAktuell.zLinkerSohn.zLinkerSohn != null) lAktuell = lAktuell.zLinkerSohn;
            return lAktuell;
        }
    }

    public ContentType getContent() {
        return zInhalt;
    }

    public BinarySearchTree<ContentType> getLeftTree() {
        return zLinkerSohn;
    }

    public BinarySearchTree<ContentType> getRightTree() {
        return zRechterSohn;
    }
}
