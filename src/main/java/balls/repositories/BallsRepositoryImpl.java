package balls.repositories;

import balls.model.Balls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("ballsRepository")
public class BallsRepositoryImpl implements BallsRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BallsRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void addBall(Balls balls) {
        jdbcTemplate.update("INSERT INTO balls (id,idStudents, idDiscipline, balls) VALUES(?, ?, ?, ?)",
                balls.getId(),
                balls.getIdStudent(),
                balls.getIdDiscipline(),
                balls.getBalls()
        );
    }

    @Override
    public void updateBall(Balls balls) {
        jdbcTemplate.update("UPDATE balls SET id=?,idStudents=?, idDiscipline=?, balls=?) VALUES(?, ?, ?, ?) WHERE id =?",
                balls.getId(),
                balls.getIdStudent(),
                balls.getIdDiscipline(),
                balls.getBalls(),
                balls.getId()

        );
    }

    @Override
    public void removeBalls(int id) {
        jdbcTemplate.update("DELETE FROM balls WHERE id =?",id);
    }

    @Override
    public Balls getBallsId(int id) {
        return this.jdbcTemplate.queryForObject("SELECT * FROM balls WHERE Id=?", Balls.class, id);
    }

    @Override
    public List<Balls> listBalls() {
        return this.jdbcTemplate.query("SELECT * FROM balls", new RowMapper<Balls>() {
            @Override
            public Balls mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Balls(
                        resultSet.getInt("id"),
                        resultSet.getInt("idStudents"),
                        resultSet.getInt("idDiscipline"),
                        resultSet.getInt("balls")
                );
            }
        });
    }
}
