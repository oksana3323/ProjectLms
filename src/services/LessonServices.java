package services;

import models.Group;
import models.Lesson;

import java.util.List;

public interface LessonServices {
    void addNewLesson(List<Lesson>lessonList, List<Group>groups,String name);
    void getAllStudentByGroupName(String name,List<Lesson>lessonList);
    void getLessonByName(String name,List<Lesson>lessons);
    void deleteLessonByName(String name,List<Lesson>lessons);
}
