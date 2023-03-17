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
        try {
            Scanner scanner = new Scanner(System.in);
            Student student = new Student();
            for (Group group : groups) {
                if (name.equalsIgnoreCase(group.getName())) {
                    System.out.print("first name : ");
                    String firstName = scanner.nextLine();
                    student.setFirstName(firstName);
                    System.out.print("last name : ");
                    String lastName = scanner.nextLine();
                    student.setLastName(lastName);
                    System.out.print("email : ");
                    String email = scanner.nextLine();
                    if (email.contains("@")) {
                        student.setEmail(email);
                        student.setEmail(email);
                    } else {
                        throw new Exception("Email должен состоять из значка @ ");
                    }
                    System.out.print("password : ");
                    String password = scanner.nextLine();
                    student.setPassword(password);
                    System.out.print("gender : ");
                    String gender = scanner.nextLine();
                    if (gender.equals(Gender.MALE.name())) {
                        student.setGender(Gender.MALE);
                        student.setGender(Gender.FEMALE);
                    } else {
                        student.setGender(Gender.FEMALE);
                    }
                    Student student1 = new Student(firstName,
                            lastName, email, password, Gender.valueOf(gender));
                    group.setStudents(List.of(student));
                    student.setGroup(group);
                    studentList.add(student1);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
    public void getAllStudentByGroupName(String name, List<Student> studentList, List<Group> groupList) {
        for (Student student : studentList) {
            if (student.getGroup().getName().equalsIgnoreCase(name)) {
                System.out.println(student);
            }
        }

    }

    @Override
    public void getAllStudentsLesson(List<Group> groups, List<Student> studentList, String lessonName) {

        for (Student student : studentList) {
            if (student.getLesson().getLessonName().equalsIgnoreCase(lessonName)) {
                System.out.println(student);
            }
        }
    }

    @Override
    public void deleteStudent(List<Student> studentList, String name) {
        for (Student student : studentList) {
            if (student.getFirstName().equalsIgnoreCase(name)) {
                studentList.remove(student);
            }
        }
    }
}
