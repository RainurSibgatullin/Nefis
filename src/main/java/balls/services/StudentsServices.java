package balls.services;

import balls.model.Student;

import java.util.List;

public interface StudentsServices {
    public void addStudent(Student student);
    public void updateStudent(Student student);
    public void removeStudent(int id);
    public Student getStudentId(int id);
    public List<Student> listStudents();
}
