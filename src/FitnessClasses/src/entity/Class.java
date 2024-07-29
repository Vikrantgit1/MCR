package entity;

import java.util.ArrayList;
import java.util.List;

public class Class {
    int id;
    String name;
    int capacity;
    List<Schedule> scheduleList = new ArrayList<>();
    boolean active;

    public Class(int id, String name, int capacity, boolean active) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Schedule> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(List<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
