package services.impl;

import enums.Gender;
import models.Group;
import models.Student;
import services.StudentServices;

import java.util.List;
import java.util.Scanner;

public class StudentServicesImpl implements StudentServices {
    @Override
    public void addNewStudentToGroup(List<Group> groups, List<Student> studentList, String name) {
        Scanner scanner = new Scanner(System.in);
        for (Group group : groups) {
            if (name.equalsIgnoreCase(group.getName())) {
                System.out.print("first name : ");
                String firstName = scanner.nextLine();
                System.out.print("last name : ");
                String lastName = scanner.nextLine();
                System.out.print("email : ");
                String email = scanner.nextLine();
                System.out.print("password : ");
                String password = scanner.nextLine();
                System.out.print("gender : ");
                String gender = scanner.nextLine();
                Student student = new Student(firstName,
                        lastName, email, password, Gender.valueOf(gender));
                group.setStudents(List.of(student));
                studentList.add(student);
            }
        }
    }

    @Override
    public void updateStudent(List<Student> studentList, String name) {
        Scanner scanner = new Scanner(System.in);
        for (Student student : studentList) {
            if (student.getFirstName().equalsIgnoreCase(name)) {
                System.out.print("first name : ");
                String firstName = scanner.nextLine();
                System.out.print("last name : ");
                String lastName = scanner.nextLine();
                System.out.print("email : ");
                String email = scanner.nextLine();
                System.out.print("password : ");
                String password = scanner.nextLine();
                System.out.print("gender : ");
                String gender = scanner.nextLine();
                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setEmail(email);
                student.setPassword(password);
                student.setGender(Gender.valueOf(gender));
            }
        }
    }

    @Override
    public Student findByName(String name, List<Student> students) {
        for (Student student : students) {
            if (student.getFirstName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public List<Student> getAllStudentByGroupName(String name, List<Student> studentList, List<Group> groupList) {

        for (Student student : studentList) {
            if (student.getGroup().equals(name)) {
                return (List<Student>) student;
            }
        }
        return null;
    }

    @Override
    public List<Student> getAllStudentsLesson(List<Group> groups, List<Student> studentList, String lessonName) {

        for (Student student : studentList) {
            for (Group group : groups) {
                if (group.getName().equals(lessonName) && group.getLessons().equals(lessonName)) {
                    return (List<Student>) student;
                    //
                }
            }
        }

        //


        return null;

    }
}