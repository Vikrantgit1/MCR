package repository;

import entity.Class;

import java.util.HashMap;

public class ClassRepo {

    HashMap<Integer, Class> registeredClasses = new HashMap<>();

    public void registerClass(Class class1) {
        registeredClasses.put(class1.getId(), class1);
    }

    public Class getClassObj(int classId) {
        return registeredClasses.get(classId);
    }
}
