package main.java.parties;

public class User extends Party
{
    String name;
    public User(String name)
    {
        super(PartyType.ePartyTypes.USER);
        this.name=name;
    }

    public String getName()
    {
        return name;
    }
}
