package service;

import entity.DaysName;
import entity.TierPackages;

public interface UserService {

    int register(String name, String mobile, TierPackages packages);

    int bookClass(int userId, int classId, DaysName daysName);

    void selectPackage(int id, TierPackages packageName);

    int cancelClass(int userId, int classId);
}
