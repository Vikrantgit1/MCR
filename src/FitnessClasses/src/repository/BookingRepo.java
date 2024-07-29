package repository;

import entity.Booking;
import entity.BookingStatus;
import entity.Class;
import entity.DaysName;
import entity.TierPackages;

import java.util.HashMap;
import java.util.Map;

public class BookingRepo {

    HashMap<Integer, Booking> bookingHashMap = new HashMap<>();

    Map<Integer, Map<DaysName, Integer>> countMap = new HashMap<>();

    Map<TierPackages, Integer> packageCount = new HashMap<>();

    public void checkAndBook(Booking booking) {
        Class aClass = booking.getClasss();

        if(countMap.containsKey(aClass.getId()) &&
                countMap.get(aClass.getId()).get(booking.getDaysName()) >= aClass.getCapacity()){
            booking.setBookingStatus(BookingStatus.WAITLIST);
            int count = countMap.get(aClass.getId()).get(booking.getDaysName());
            countMap.get(aClass.getId()).put(booking.getDaysName(),count+1);
            booking.setWaitlistNo(count+1);
            System.out.println("in waiting..");
        } else if (booking.getUser().getCurrentBookings().size() ==
                packageCount.get(booking.getUser().getPackages())) {
            System.out.println("Exceeding package limit for user");
            booking.setBookingStatus(BookingStatus.CANCELLED);
        } else {
            Map<DaysName, Integer> map = countMap.containsKey(aClass.getId()) ? countMap.get(aClass.getId()):new HashMap<>();
            int count = map.containsKey(booking.getDaysName()) ?
                    map.get(booking.getDaysName()) : 0;
            map.put(booking.getDaysName(),count+1);
            countMap.put(aClass.getId(),map);
            booking.getUser().getCurrentBookings().add(booking.getId());
            booking.setBookingStatus(BookingStatus.CONFIRMED);
        }

    }

    public void setPackageCountMap() {
        packageCount.put(TierPackages.PLATINUM,10);
        packageCount.put(TierPackages.GOLD,5);
        packageCount.put(TierPackages.SILVER,3);
    }
}
