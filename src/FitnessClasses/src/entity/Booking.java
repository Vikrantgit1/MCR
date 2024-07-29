package entity;

public class Booking {
    int id;
    Class classs;
    User user;
    BookingStatus bookingStatus;
    DaysName daysName;
    int waitlistNo=0;


    public Booking(int id, Class classs, User user, BookingStatus bookingStatus, DaysName daysName) {
        this.id = id;
        this.classs = classs;
        this.user = user;
        this.bookingStatus = bookingStatus;
        this.daysName = daysName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Class getClasss() {
        return classs;
    }

    public void setClasss(Class classs) {
        this.classs = classs;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public DaysName getDaysName() {
        return daysName;
    }

    public void setDaysName(DaysName daysName) {
        this.daysName = daysName;
    }

    public int getWaitlistNo() {
        return waitlistNo;
    }

    public void setWaitlistNo(int waitlistNo) {
        this.waitlistNo = waitlistNo;
    }
}
