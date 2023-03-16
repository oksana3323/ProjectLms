package models;

public class Lesson {
    private String lessonName;
    private Group group;
    private Student student;

    public Lesson(String lessonName, Group group, Student student) {
        this.lessonName = lessonName;
        this.group = group;
        this.student = student;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "lessonName='" + lessonName + '\'' +
                ", group=" + group +
                ", student=" + student +
                '}';
    }
}
