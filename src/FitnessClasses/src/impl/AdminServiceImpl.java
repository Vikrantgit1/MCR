package impl;

import entity.Class;
import entity.DaysName;
import entity.Schedule;
import repository.ClassRepo;
import repository.ScheduleRepo;
import service.AdminService;

import java.time.LocalTime;


public class AdminServiceImpl implements AdminService {

    static int classId=0;
    static int scheduleId=0;

    ClassRepo classRepo;
    ScheduleRepo scheduleRepo;

    public AdminServiceImpl(ClassRepo classRepo, ScheduleRepo scheduleRepo) {
        this.classRepo = classRepo;
        this.scheduleRepo = scheduleRepo;
    }

    @Override
    public int createClass(String name, int capacity) {
        Class class1 = new Class(getNewId("class"),name,capacity,true);
        classRepo.registerClass(class1);
        System.out.println("Class created successfully! \nName : "+name+"\nCapacity : "+capacity);
        return class1.getId();
    }

    @Override
    public void scheduleClass(int classId, int scheduleId, LocalTime startTime, LocalTime endTime, DaysName daysName) {
        Schedule schedule;
        if(scheduleId==0){
            schedule = new Schedule(getNewId("Schedule"),startTime,endTime,daysName);
            scheduleRepo.createSchedule(schedule);
        }
        else {
            schedule = scheduleRepo.getSchedule(scheduleId);
        }
        System.out.println("Class scheduled successfully.");
        classRepo.getClassObj(classId).getScheduleList().add(schedule);
    }

    private int getNewId(String entity) {
        switch (entity){
            case "class" : {
                classId = classId + 1;
                return classId;
            }
            case "schedule" : {
                scheduleId = scheduleId + 1;
                return scheduleId;
            }
        }
        return 0;
    }


    @Override
    public int cancelClass(int id) {
        classRepo.getClassObj(id).setActive(false);
        System.out.println("Class cancelled.");
        return id;
    }
}
