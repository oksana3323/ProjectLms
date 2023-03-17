package services.impl;

import models.Group;
import models.Lesson;
import services.LessonServices;

import java.util.List;
import java.util.Scanner;

public class LessonServicesImpl implements LessonServices {
    private  int num = 1;
    @Override
    public void addNewLesson(List<Lesson>lessonList,List<Group>groupList,String name) {
        Scanner scanner = new Scanner(System.in);
        for (Group group : groupList) {
            if(group.getName().equalsIgnoreCase(name)) {
                System.out.print("Enter a name for the new lesson : ");
                String name1 = scanner.nextLine();
                Lesson lesson = new Lesson(num++, name1);
                group.setLessons(List.of(lesson));
                lesson.setGroup(group);
                lessonList.add(lesson);
            }
        }
    }
    @Override
    public void getAllStudentByGroupName(String name,List<Lesson>lessonList){
        for (Lesson lesson : lessonList) {
            if (lesson.getGroup().getName().equalsIgnoreCase(name)){
                System.out.println(lesson);
            }
        }
    }

    @Override
    public void getLessonByName(String name, List<Lesson> lessons) {
        for (Lesson lesson : lessons) {
            if(lesson.getLessonName().equalsIgnoreCase(name)){
                System.out.println(lesson);
            }
        }
    }

    @Override
    public void deleteLessonByName(String name, List<Lesson> lessons) {
        for (Lesson lesson : lessons) {
            if(lesson.getLessonName().equalsIgnoreCase(name)){
                lessons.remove(lesson);
            }
        }
    }
}
