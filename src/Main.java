import models.Group;
import models.Lesson;
import models.Student;
import models.Users;
import services.StudentServices;
import services.impl.GroupServicesImpl;
import services.impl.LessonServicesImpl;
import services.impl.StudentServicesImpl;
import services.impl.UsersServicesImpl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minutes = calendar.get(Calendar.MINUTE);
        if (hour > 1 && hour <= 11) {
            System.out.println("Kutman tan:" + hour + ":" + minutes);
        }
        if (hour > 12 && hour <= 18) {
            System.out.println("Kutman kun: "+hour+":"+minutes);
        } else if (hour > 18 && hour <= 23) {
            System.out.println("Kuyman kech"+hour+":"+minutes);
        }
        Scanner scanner = new Scanner(System.in);

        List<Group> groupList = new ArrayList<>();
        List<Student> studentList = new ArrayList<>();
        List<Lesson> lessonList = new ArrayList<>();

        UsersServicesImpl usersServices = new UsersServicesImpl();

        StudentServicesImpl studentServices = new StudentServicesImpl();
        GroupServicesImpl groupServices = new GroupServicesImpl();
        LessonServicesImpl lessonServices = new LessonServicesImpl();

        Users users = new Users("oksana@gmail.com", "oksana");
        System.out.println( users.getEmail());

        Group group = new Group();

        while (true
        ) {
            try {
                System.out.println("0 Басыныз ");
                String email=scanner.nextLine();
                System.out.print("email : ");
                String email1 = scanner.nextLine();
                System.out.print("password : ");
                String password = scanner.nextLine();

                String yes = usersServices.yesOrNot(email, password, users);
                if (yes.equals("no")) {
                    throw new NullPointerException("Please write your email or password first");
                }
                if (yes.equals("yes")) {
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
                                 10 -> Delete lesson
                                 11 -> Add new lesson to group
                                 12 -> Get lesson by name
                                 13 -> Get all lesson by group name
                                 14 -> Delete student
                                 15 -> Delete group
                                """);

                        switch (scanner.nextInt()) {
                            case 0:
                                groupServices.User();
                                String a = scanner.nextLine();
                                System.out.println(a + " ");
                                break;
                            case 1:
                                groupServices.addNewGroup(groupList);
                                System.out.println(groupList + " ");
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
                                System.out.println("Add new student to group");
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
                                break;
                            case 10:
                                String ff = scanner.nextLine();
                                System.out.print("Lesson Name: ");
                                lessonServices.deleteLessonByName(scanner.nextLine(),lessonList);
                            case 11:
                                String d = scanner.nextLine();
                                System.out.print("group name : ");
                                lessonServices.addNewLesson(lessonList,groupList,scanner.nextLine());
                                break;
                            case 12:
                                String ffd = scanner.nextLine();
                                System.out.print("Lesson Name: ");
                                lessonServices.getLessonByName(scanner.nextLine(),lessonList);
                            case 13:
                                String sd = scanner.nextLine();
                                System.out.print("group name : ");
                                lessonServices.getAllStudentByGroupName(scanner.nextLine(),lessonList);
                                break;
                            case 14:
                                String sd9 = scanner.nextLine();
                                System.out.print("student name : ");
                                studentServices.deleteStudent(studentList,scanner.nextLine());
                                break;
                            case 15:
                                String sd93 = scanner.nextLine();
                                System.out.print("group name : ");
                                groupServices.deleteStudentByName(scanner.nextLine(),groupList);

                        }
                    }
                } else {
                    System.out.println("no");
                }
            }catch (NullPointerException e){
                System.out.println(e);
            }
        }
    }
}

