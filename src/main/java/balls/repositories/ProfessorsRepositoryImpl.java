package balls.repositories;

import balls.model.Professors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("professorsRepository")
public class ProfessorsRepositoryImpl implements ProfessorsRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProfessorsRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void addProfessor(Professors professors) {
        jdbcTemplate.update("INSERT INTO professors (id, familyProfessors, nameProfessors, nameFatherProfessors) VALUES(?, ?, ?, ?)",
                professors.getId(),
                professors.getFamilyProfessors(),
                professors.getNameProfessors(),
                professors.getNameFatherProfessors()
        );
    }

    @Override
    public void updateProfessor(Professors professors) {
        jdbcTemplate.update("UPDATE professors SET id=?,familyProfessors=?, nameProfessors=?, nameFatherProfessors=?)  VALUES(?, ?, ?, ?) WHERE id =?",
                professors.getId(),
                professors.getFamilyProfessors(),
                professors.getNameProfessors(),
                professors.getNameFatherProfessors(),
                professors.getId()
        );
    }

    @Override
    public void removeProfessor(int id) {
        jdbcTemplate.update("DELETE FROM professors WHERE id =?", id);
    }

    @Override
    public Professors getProfessor(int id) {
        return this.jdbcTemplate.queryForObject("SELECT * FROM professors WHERE Id=?", Professors.class, id);
    }

    @Override
    public List<Professors> getAllProfessors() {
        return this.jdbcTemplate.query("SELECT * FROM professors", new RowMapper<Professors>() {
            @Override
            public Professors mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Professors(
                        resultSet.getInt("id"),
                        resultSet.getString("familyProfessor"),
                        resultSet.getString("nameProfessor"),
                        resultSet.getString("nameFatherProfessor")
                );
            }
        });
    }
}
