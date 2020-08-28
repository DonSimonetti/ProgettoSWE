package main.java.parties;

public class Party
{
    private PartyType partyType;

    public Party(PartyType.ePartyTypes partyType)
    {
        this.partyType=new PartyType(partyType);
    }

    public PartyType getType()
    {
        return new PartyType(partyType.getType());
    }
}
