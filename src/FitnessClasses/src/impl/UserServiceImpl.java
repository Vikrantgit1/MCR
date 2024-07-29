package impl;

import entity.Booking;
import entity.DaysName;
import entity.TierPackages;
import entity.User;
import repository.BookingRepo;
import repository.ClassRepo;
import repository.UserRepo;
import service.UserService;

public class UserServiceImpl implements UserService {

    static int userId = 0;
    static int bookingId = 0;

    UserRepo userRepo;
    BookingRepo bookingRepo;
    ClassRepo classRepo;

    public UserServiceImpl(UserRepo userRepo, BookingRepo bookingRepo, ClassRepo classRepo) {
        this.userRepo = userRepo;
        this.bookingRepo = bookingRepo;
        this.classRepo = classRepo;
    }

    @Override
    public int register(String name, String mobile, TierPackages packages) {
        User newUser = new User(getNewId("user"), name, mobile, packages);
        userRepo.registerUser(newUser);
        System.out.println("User registered successfully! \nName : "+name+"\nMobile : "+mobile);
        return newUser.getId();
    }

    @Override
    public int bookClass(int userId, int classId, DaysName daysName) {
        if(!classActive(classId)){
            System.out.println("Class is inactive! Try something else");
        }
        Booking booking = new Booking(getNewId("booking"),classRepo.getClassObj(classId),
                userRepo.getUser(userId),null,daysName);
        bookingRepo.checkAndBook(booking);
        System.out.println("Class booking successful. Status : "+booking.getBookingStatus()+" waitlist = "+booking.getWaitlistNo());
        return booking.getId();
    }

    private boolean classActive(int classId) {
        return classRepo.getClassObj(classId).isActive();
    }

    @Override
    public void selectPackage(int id, TierPackages packageName) {
        userRepo.getUser(id).setPackages(packageName);
    }

    @Override
    public int cancelClass(int userId, int classId) {
        return 0;
    }

    private int getNewId(String entity) {
        switch (entity){
            case "user" : {
                userId = userId + 1;
                return userId;
            }
            case "booking" : {
                bookingId = bookingId + 1;
                return bookingId;
            }
        }
        return 0;
    }
}
