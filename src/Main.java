import models.Group;
import models.Lesson;
import models.Student;
import models.Users;
import services.StudentServices;
import services.impl.GroupServicesImpl;
import services.impl.StudentServicesImpl;
import services.impl.UsersServicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Group> groupList = new ArrayList<>();
        List<Student> studentList = new ArrayList<>();
        List<Lesson> lessonList = new ArrayList<>();

        UsersServicesImpl usersServices = new UsersServicesImpl();
        StudentServicesImpl studentServices = new StudentServicesImpl();
        GroupServicesImpl groupServices = new GroupServicesImpl();

        Users users = new Users("oksana@gmail.com", "oksana");
        Group group = new Group("java", "java");
        groupList.add(group);
        String yes = null;
        while (true) {
            System.out.println("""
                     1  -> Add new group
                     2  -> Get group by name
                     3  -> Update group name
                     4  -> Get all groups
                     5  -> Add new student to group
                     6  -> Update student
                     7  -> Find student by first name
                     8  -> Get all students by group name
                     9  -> Get all student's lesson
                     10 -> Delete student
                     11 -> Add new lesson to group
                     12 -> Get lesson by name
                     13 -> Get all lesson by group name
                     14 -> Delete lesson
                     15 -> Delete group
                    """);
            switch (scanner.nextInt()) {
                case 1:
                    groupServices.addNewGroup(groupList);
                    System.out.println(groupList);
                    break;
                case 2:
                    String s = scanner.nextLine();
                    groupServices.getGroupByName(groupList, scanner.nextLine());
                    break;
                case 3:
                    String ss = scanner.nextLine();
                    System.out.print("name : ");
                    groupServices.updateGroupByName(groupList, scanner.nextLine());
                    break;
                case 4:
                    for (Group group1 : groupList) {
                        System.out.println(group1);
                    }
                    break;
                case 5:
                    String sss = scanner.nextLine();
                    System.out.print("group name: ");
                    studentServices.addNewStudentToGroup(groupList, studentList, scanner.nextLine());
                    break;
                case 6:
                    String sss1 = scanner.nextLine();
                    System.out.print("name: ");
                    studentServices.updateStudent(studentList, scanner.nextLine());
                    break;
                case 7:
                    String sss2 = scanner.nextLine();
                    System.out.print("name: ");
                    System.out.println(studentServices.findByName(scanner.nextLine(), studentList));
                    break;
                case 8:
                    System.out.println();

                    String sss3 = scanner.nextLine();
                    System.out.println("Name:");
                    studentServices.getAllStudentByGroupName(scanner.nextLine(), studentList, groupList);
                    break;
                case 9:
                    System.out.println();
                    String sss5 = scanner.nextLine();
                    System.out.println("Lesson Name: ");
                    studentServices.getAllStudentsLesson(groupList, studentList, scanner.nextLine());

            }
        }
    }
}