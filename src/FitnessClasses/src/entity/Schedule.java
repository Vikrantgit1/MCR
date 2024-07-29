package entity;

import java.time.LocalTime;
import java.util.Date;

public class Schedule {
    int id;
    LocalTime startTime;
    LocalTime endTime;
    DaysName daysName;

    public Schedule(int id, LocalTime startTime, LocalTime endTime, DaysName daysName) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.daysName = daysName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public DaysName getDaysName() {
        return daysName;
    }

    public void setDaysName(DaysName daysName) {
        this.daysName = daysName;
    }
}

