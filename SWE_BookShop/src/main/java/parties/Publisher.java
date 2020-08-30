package main.java.parties;

/*
 *
 *   Publisher.java class represents publishers of books that at some point were in the bookshop
 *
 * */

public class Publisher extends Party
{
    private String name;

    public Publisher(String name)
    {
        super(PartyType.ePartyTypes.PUBLISHER);
        this.name=name;
    }

    public String getName()
    {
        return name;
    }
}