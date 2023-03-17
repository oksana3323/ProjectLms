package services;

import models.Group;
import models.Users;

import java.util.List;

public interface GroupServices {
    void addNewGroup(List<Group> groupList);

    void getGroupByName(List<Group> groupList, String name);

    void updateGroupByName(List<Group> groupList, String name);

    void User();

    void User(List<Users> users);
    void deleteStudentByName(String name,List<Group>groups);


}
