package main.java.parties;

/*
*
*   User class represents actual registered users
*
* */

public class User extends Party
{
    public User(String name, PartyType.ePartyTypes userType) throws Exception
    {
        super(userType);

        if(!(userType== PartyType.ePartyTypes.USER || userType== PartyType.ePartyTypes.PUBLISHER || userType== PartyType.ePartyTypes.MODERATOR))
            throw new Exception("Invalid 'userType' parameter for User");

        this.name=name;
    }

    public String getName()
    {
        return name;
    }

    private String name;
}
