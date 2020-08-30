package main.java.accountability;

public class AccountabilityType
{
    public enum eAccountabilityTypes
    {
        RECOMMENDS,
        JOINS,
        EDITION,
        COMMENTS,
        WRITTEN_BY,
        ASSOCIATED_WITH
    }

    private eAccountabilityTypes type;

    public AccountabilityType(eAccountabilityTypes type)
    {
        this.type=type;
    }

    public eAccountabilityTypes getType()
    {
        return this.type;
    }
}
