package taks.projekte.fastsearch;

public class SearchElement<ContentType> {
    private ContentType reference;
    private String [] keywordarray = new String [100];

    SearchElement(ContentType reference, String keyword){
        this.reference = reference;
        keywordarray[0] = keyword;
    }

    public void addKeyword(String keyword){
        int i = keywordarray.length;
        if(i < 100){
            keywordarray[i] = keyword;
        }
    }

    public void deleteKeyword(String keyword){
        int i = keywordarray.length;
        for (int j= 0; j<i; j++){
            if(keywordarray[j].equals(keyword)) keywordarray[j];
        }
    }

    public ContentType getReference() {
        return reference;
    }

    public String[] getKeywordarray() {
        return keywordarray;
    }

    public void setKeywordarray(String[] keywordarray) {
        this.keywordarray = keywordarray;
    }

    public void setReference(ContentType reference) {
        this.reference = reference;
    }
}
