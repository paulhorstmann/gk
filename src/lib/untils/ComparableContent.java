package lib.untils;

public interface ComparableContent<ContentType>
{
    public boolean isEqual(ContentType pComparableContent);
    public boolean isGreater(ContentType pComparableContent);
    public boolean isLess(ContentType pComparableContent);
}
