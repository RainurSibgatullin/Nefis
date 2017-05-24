package balls.repositories;

import balls.model.Student;

import java.util.List;

public interface StudentsRepository {
    void addStudent(Student students);
    public void updateStudent(Student students);
    public void removeStudent(int id);
    Student getStudent(int id);
    List<Student> getAllStudents();
}
