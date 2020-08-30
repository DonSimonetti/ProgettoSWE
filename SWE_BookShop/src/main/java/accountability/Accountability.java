package main.java.accountability;

import main.java.TimeRecord;
import main.java.parties.Party;

import java.util.List;

public class Accountability
{
    private Party primary;
    private AccountabilityType type;
    private Party secondary;
    private TimeRecord timeRecord;

    private static List<Accountability> accountabilities;

    public Accountability(Party primary, AccountabilityType type, Party secondary, TimeRecord timeRecord)
    {
        this.primary=new Party(primary.getType().getType());
        this.type=new AccountabilityType(type.getType());
        this.secondary=new Party(secondary.getType().getType());
        this.timeRecord=new TimeRecord(timeRecord.getStartTime(),timeRecord.getEndTime());
    }
}
