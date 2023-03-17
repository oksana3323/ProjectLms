package services.impl;

import models.Group;
import models.Users;
import services.GroupServices;

import java.util.List;
import java.util.Scanner;

public class GroupServicesImpl implements GroupServices {
    int num = 1;

    @Override
    public void addNewGroup(List<Group> groupList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a name for the new group : ");
        String name = scanner.nextLine();
        System.out.print("description : ");
        String description = scanner.nextLine();
        Group group = new Group(name, description, num++);
        groupList.add(group);
    }

    @Override
    public void getGroupByName(List<Group> groupList, String name) {
        System.out.println("Get group by name:  ");
        for (Group group : groupList) {
            if (group.getName().equalsIgnoreCase(name)) {
                System.out.println(group);
            }
        }
    }

    @Override
    public void updateGroupByName(List<Group> groupList, String name) {
        Scanner scanner = new Scanner(System.in);
        for (Group group : groupList) {
            if (group.getName().equalsIgnoreCase(name)) {
                System.out.print("Write new name : ");
                String name1 = scanner.nextLine();
                System.out.print("description : ");
                String description = scanner.nextLine();
                group.setName(name1);
                group.setDescriptions(description);
            }
        }
    }

    @Override
    public void User() {

    }

    @Override
    public void User(List<Users> users) {
        try {
            System.out.println(" Elektronduk pochtanyzdy jazynyz");
            String name = new Scanner(System.in).nextLine();
            System.out.println("Parol");
            String Password = new Scanner(System.in).nextLine();


            for (Users user : users) {
                if (!user.getEmail().equalsIgnoreCase(name)) {
                    throw new Exception("Your email adress is not valid");
                }
                if (user.getPassword().equalsIgnoreCase(Password)) {
                    throw new Exception("error");

                }


            }

        } catch (Exception e) {
            System.out.println(e.getMessage());


              }


    }

    @Override
    public void deleteStudentByName(String name, List<Group> groups) {
        for (Group group : groups) {
            if(group.getName().equalsIgnoreCase(name)){
                groups.remove(group);
            }
        }
    }
}