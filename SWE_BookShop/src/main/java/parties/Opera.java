package main.java.parties;

/*
 *
 *   Opera.java class represents operas that at some point in time were in the bookshop
 *
 * */

public class Opera extends Party
{
    private String title;
    int yearFirstPublication;
    private List<String> tags;

    public Opera(String title, int yearFirstPublication) // use a vararg to add all the tags?
    {
        super(PartyType.ePartyTypes.OPERA_WORK);
        this.title=title;
        this.yearFirstPublication=yearFirstPublication;
    }

    public String getTitle()
    {
        return title;
    }
    public int getYearFirstPublication()
    {
        return yearFirstPublication;
    }
    public List<String> getTags(){
        return tags;
    }


    public addTag(String tag)
    {
        tags.add(tag);
    }
    public addTag(List<String> tag)
    {
        tags.addAll(tag)
    }
}