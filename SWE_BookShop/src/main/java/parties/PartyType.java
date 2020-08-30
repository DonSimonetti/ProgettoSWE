package main.java.parties;

public final class PartyType
{
    public enum ePartyTypes
    {
        OPERA_WORK,
        EDITION,
        COMMENT,
        BOOK,
        USER,
        PUBLISHER,
        AUTHOR,
        GROUP,
        BOOK_LIST
    }

    private ePartyTypes partyType;

    public PartyType(ePartyTypes partyType)
    {
        this.partyType=partyType;
    }

    public ePartyTypes getType()
    {
        return partyType;
    }
}
