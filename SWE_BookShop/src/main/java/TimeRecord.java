package main.java;

import java.sql.Time;

public class TimeRecord
{
    private Time startTime;
    private Time endTime;

    public TimeRecord(Time startTime, Time endTime)
    {
        this.startTime=new Time(startTime.getTime());
        this.endTime=new Time(endTime.getTime());
    }

    public Time getStartTime()
    {
        return new Time(startTime.getTime());
    }

    public Time getEndTime()
    {
        return new Time(endTime.getTime());
    }

    public long getTimeSpan()
    {
        return endTime.getTime()-startTime.getTime();
    }
}
