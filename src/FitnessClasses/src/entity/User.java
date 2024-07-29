package entity;

import java.util.ArrayList;
import java.util.List;

public class User {
    int id;
    String name;
    String mobile;
    TierPackages packages;
    List<Integer> currentBookings = new ArrayList<>();

    public User(int id, String name, String mobile, TierPackages packages) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.packages = packages;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public TierPackages getPackages() {
        return packages;
    }

    public void setPackages(TierPackages packages) {
        this.packages = packages;
    }

    public List<Integer> getCurrentBookings() {
        return currentBookings;
    }

    public void setCurrentBookings(List<Integer> currentBookings) {
        this.currentBookings = currentBookings;
    }
}
