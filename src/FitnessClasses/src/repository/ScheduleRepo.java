package repository;

import entity.Schedule;

import java.util.HashMap;

public class ScheduleRepo {

    HashMap<Integer, Schedule> scheduleMap = new HashMap<>();

    public void createSchedule(Schedule schedule) {
        scheduleMap.put(schedule.getId(), schedule);
    }

    public Schedule getSchedule(int scheduleId) {
        return scheduleMap.get(scheduleId);
    }
}
