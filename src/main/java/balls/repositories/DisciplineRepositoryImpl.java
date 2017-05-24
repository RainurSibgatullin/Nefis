package balls.repositories;

import balls.model.Discipline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("disciplineRepository")
public class DisciplineRepositoryImpl implements DisciplineRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DisciplineRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public List<Discipline> getAllDisciplines(int id) {
        return this.jdbcTemplate.query("SELECT * FROM discipline WHERE IdProfessor=?", new RowMapper<Discipline>() {
            @Override
            public Discipline mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Discipline(resultSet.getString("nameDiscipline"));
            }
        },id);
    }
}
