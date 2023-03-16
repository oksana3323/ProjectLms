package services.impl;

import models.Group;
import models.Lesson;
import models.Student;
import services.GroupServices;

import java.util.List;
import java.util.Scanner;

public class GroupServicesImpl implements GroupServices {
    @Override
    public void addNewGroup(List<Group> groupList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("name : ");
        String name = scanner.nextLine();
        System.out.print("description : ");
        String description = scanner.nextLine();
        groupList.add(new Group(name,description));
    }

    @Override
    public void getGroupByName(List<Group> groupList,String name) {
        for (Group group : groupList) {
            if(group.getName().equalsIgnoreCase(name)){
                System.out.println(group);
            }
        }
    }
    @Override
    public void updateGroupByName(List<Group> groupList,String name) {
        Scanner scanner = new Scanner(System.in);
        for (Group group : groupList) {
            if(group.getName().equalsIgnoreCase(name)){
                System.out.print("name : ");
                String name1 = scanner.nextLine();
                System.out.print("description : ");
                String description = scanner.nextLine();
                group.setName(name1);
                group.setDescriptions(description);
            }
        }
    }


}
