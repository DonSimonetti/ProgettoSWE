package main.java.parties;

/*
 *
 *   Group.java class represents groups of users who share a common interest for a book or an author
 *
 * */

public class Group extends Party
{
    private String name;

    // serve uno User per creare un Group?
    public Group(String name)
    {
        super(PartyType.ePartyTypes.GROUP);
        this.name=name;
    }

    public String getName()
    {
        return name;
    }
}