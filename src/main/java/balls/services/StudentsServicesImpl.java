package balls.services;

import balls.model.Student;
import balls.repositories.GroupsRepository;
import balls.repositories.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("studentsServices")
public class StudentsServicesImpl implements StudentsServices {
    private StudentsRepository studentsRepository;

    @Autowired
    public void setStudentsRepository(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    @Override
    @Transactional
    public void addStudent(Student student) {
        this.studentsRepository.addStudent(student);
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        this.studentsRepository.updateStudent(student);
    }

    @Override
    @Transactional
    public void removeStudent(int id) {
        this.studentsRepository.removeStudent(id);
    }

    @Override
    @Transactional
    public Student getStudentId(int id) {
        return this.studentsRepository.getStudent(id);
    }

    @Override
    @Transactional
    public List<Student> listStudents() {
        return this.studentsRepository.getAllStudents();
    }
}



