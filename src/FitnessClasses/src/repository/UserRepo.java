package repository;

import entity.User;

import java.util.HashMap;

public class UserRepo {

    HashMap<Integer, User> userHashMap = new HashMap<>();

    public void registerUser(User newUser) {
        userHashMap.put(newUser.getId(), newUser);
    }

    public User getUser(int id){
        return userHashMap.get(id);
    }
}
