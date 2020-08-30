package main.java.parties;

/*
 *
 *   Author.java class represents authors of books that at some point were in the bookshop
 *
 * */

public class Author extends Party
{
    private String name;

    public Author(String name)
    {
        super(PartyType.ePartyTypes.AUTHOR);
        this.name=name;
    }

    public String getName()
    {
        return name;
    }
}