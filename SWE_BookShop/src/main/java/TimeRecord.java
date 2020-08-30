package main.java;

import java.sql.Time;

public class TimeRecord
{
    private Time startTime;
    private Time endTime;

    public TimeRecord(Time startTime, Time endTime)
    {
        this.startTime=startTime;
        this.endTime=endTime;
    }

    public Time getStartTime()
    {
        return startTime;
    }

    public Time getEndTime()
    {
        return endTime;
        //or return new Time(endTime.getTime()); ??
    }

    public long getTimeSpan()
    {
        return endTime.getTime()-startTime.getTime();
    }
}
