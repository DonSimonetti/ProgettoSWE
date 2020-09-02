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
        MODERATOR,
        GROUP,
        AUTHOR,
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
