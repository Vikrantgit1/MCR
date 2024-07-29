package service;

import entity.DaysName;
import entity.Schedule;

import java.time.LocalTime;
import java.util.List;

public interface AdminService {

    int createClass(String name, int capacity);

    void scheduleClass(int classId, int scheduleId, LocalTime startTime, LocalTime endTime, DaysName daysName);

    int cancelClass(int id);

}
