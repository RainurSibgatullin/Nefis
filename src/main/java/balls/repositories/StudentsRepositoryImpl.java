package balls.repositories;

import balls.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("studentsRepository")
public class StudentsRepositoryImpl implements StudentsRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentsRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void addStudent(Student students) {
        jdbcTemplate.update("INSERT INTO student (id, familystudents, namestudents, namefatherstudents, birthdate, idgroup) VALUES(?, ?, ?, ?, ?, ?)",
                students.getId(),
                students.getFamilyStudents(),
                students.getNameStudents(),
                students.getNameFatherStudents(),
                students.getBirthdate(),
                students.getIdGroup()
        );
    }

    @Override
    public void updateStudent(Student students) {
        jdbcTemplate.update("UPDATE student SET id = ?,familystudents = ?, namestudents  = ?, namefatherstudents  = ?, birthdate  = ?, idgroup  = ?)  VALUES(?, ?, ?, ?, ?, ?) WHERE id =?",
                students.getId(),
                students.getFamilyStudents(),
                students.getNameStudents(),
                students.getNameFatherStudents(),
                students.getBirthdate(),
                students.getIdGroup(),
                students.getId()
        );
    }

    @Override
    public void removeStudent(int id) {
        jdbcTemplate.update("DELETE FROM student WHERE id =?", id);
    }

    @Override
    public Student getStudent(int id) {
        return this.jdbcTemplate.queryForObject("SELECT * FROM student WHERE Id=?", Student.class, id);
    }

    @Override
    public List<Student> getAllStudents() {
        return this.jdbcTemplate.query("SELECT * FROM student", new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("familyStudent"),
                        resultSet.getString("nameStudent"),
                        resultSet.getString("nameFatherStudent"),
                        resultSet.getDate("birthdate"),
                        resultSet.getInt("idGroup")
                );
            }
        });
    }
}
