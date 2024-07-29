package FitnessClasses;

import entity.DaysName;
import entity.TierPackages;
import impl.AdminServiceImpl;
import impl.UserServiceImpl;
import repository.BookingRepo;
import repository.ClassRepo;
import repository.ScheduleRepo;
import repository.UserRepo;
import service.AdminService;
import service.UserService;

import java.time.LocalTime;

public class Main1 {
    public static void main(String[] args) {

        BookingRepo bookingRepo = new BookingRepo();
        ClassRepo classRepo = new ClassRepo();
        ScheduleRepo scheduleRepo = new ScheduleRepo();
        UserRepo userRepo = new UserRepo();

        AdminService adminService = new AdminServiceImpl(classRepo,scheduleRepo);
        UserService userService = new UserServiceImpl(userRepo,bookingRepo,classRepo);

        bookingRepo.setPackageCountMap();

        //create classes
        adminService.createClass("Yoga",40);
        adminService.createClass("Dance", 30);


        //schedule classes
        adminService.scheduleClass(1,0, LocalTime.of(6,0,0),
                LocalTime.of(7,45,0), DaysName.SUNDAY);
        adminService.scheduleClass(2,0,LocalTime.of(8,0,0),
                LocalTime.of(8,45,0), DaysName.SUNDAY);

        // user register
        userService.register("Vik","1111111111", TierPackages.PLATINUM);


        // book classes
        userService.bookClass(1, 1, DaysName.SUNDAY);

        System.out.println("end");

    }
}