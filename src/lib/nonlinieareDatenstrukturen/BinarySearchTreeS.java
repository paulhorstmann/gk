package lib.nonlinieareDatenstrukturen;

public class BinarySearchTreeS<ContentType> {

    protected ContentType zInhalt;
    protected int zSchluessel;
    protected BinarySearchTreeS<ContentType> zLinkerSohn, zRechterSohn;

    public boolean isEmpty() {
        return zInhalt == null;
    }

    public void insert(ContentType pContent, int pSchluessel) {
        if (isEmpty()) {
            zInhalt = pContent;
            zSchluessel = pSchluessel;
            zLinkerSohn = new BinarySearchTreeS<>();
            zRechterSohn = new BinarySearchTreeS<>();
        } else {
            if (pSchluessel < zSchluessel) {
                zLinkerSohn.insert(pContent, pSchluessel);
            } else if (pSchluessel > zSchluessel) {
                zRechterSohn.insert(pContent, pSchluessel);
            }
        }
    }

    public ContentType search(int pSchluessel) {
        if (!isEmpty()) {
            if (zSchluessel > pSchluessel) {
                return zLinkerSohn.search(pSchluessel);
            } else if (zSchluessel < pSchluessel) {
                return zRechterSohn.search(pSchluessel);
            } else {
                return zInhalt;
            }
        }
        return null;
    }

    public void remove(int pSchluessel) {
        if (!isEmpty()) {
            if (!isEmpty() && zSchluessel > pSchluessel) {
                zLinkerSohn.remove(pSchluessel);
            } else if (!zRechterSohn.isEmpty() && zSchluessel < pSchluessel) {
                zRechterSohn.remove(pSchluessel);
            } else if (zSchluessel == pSchluessel) {
                if (!zLinkerSohn.isEmpty() && !zRechterSohn.isEmpty()) {
                    BinarySearchTreeS<ContentType> min = zRechterSohn;
                    while (!min.zLinkerSohn.isEmpty()) {
                        min = min.zLinkerSohn;
                    }
                    zInhalt = min.zInhalt;
                    zSchluessel = min.zSchluessel;
                    if (zRechterSohn == min) {
                        zRechterSohn = zRechterSohn.zRechterSohn;
                    } else if (!min.zRechterSohn.isEmpty()) {
                        min.zInhalt = min.zRechterSohn.zInhalt;
                        min.zSchluessel = min.zRechterSohn.zSchluessel;
                        min.zLinkerSohn = min.zRechterSohn.zLinkerSohn;
                        min.zRechterSohn = min.zRechterSohn.zRechterSohn;
                    } else {
                        min.zRechterSohn = null;
                        min.zLinkerSohn = null;
                        min.zInhalt = null;
                    }
                } else if (!zLinkerSohn.isEmpty()) {
                    zInhalt = zLinkerSohn.zInhalt;
                    zSchluessel = zLinkerSohn.zSchluessel;
                    zLinkerSohn = zLinkerSohn.zLinkerSohn;
                } else if (!zRechterSohn.isEmpty()) {
                    zInhalt = zRechterSohn.zInhalt;
                    zSchluessel = zRechterSohn.zSchluessel;
                    zRechterSohn = zRechterSohn.zRechterSohn;
                } else {
                    zInhalt = null;
                    zLinkerSohn = null;
                    zRechterSohn = null;
                }
            }
        }
    }

    public ContentType getContent() {
        return zInhalt;
    }

    public BinarySearchTreeS<ContentType> getLeftTree() {
        return zLinkerSohn;
    }

    public BinarySearchTreeS<ContentType> getRightTree() {
        return zRechterSohn;
    }

    public int gibSchlüssel() {
        return zSchluessel;
    }
}