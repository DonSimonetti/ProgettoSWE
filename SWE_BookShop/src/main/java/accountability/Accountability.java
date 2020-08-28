package main.java.accountability;

import main.java.parties.Party;

import java.util.List;

public class Accountability
{
    private Party primary;
    private AccountabilityType type;
    private Party secondary;
    //private TimeRecord timeRecord;

    private static List<Accountability> accountabilities;

    public Accountability(Party primary, AccountabilityType type, Party secondary/*, TimeRecord timeRecord=null*/)
    {
        this.primary=primary;
        this.type=type;
        this.secondary=secondary;
        //this.timeRecord=timeRecord;
    }
}
