package balls.model;

import javax.persistence.*;

@Entity
@Table(name = "balls", schema = "students", catalog = " ")
public class Balls{
    private int id;
    private int idStudent;
    private int idDiscipline;
    private int balls;

    public Balls(int id, int idStudent, int idDiscipline, int balls) {
        this.id = id;
        this.idStudent = idStudent;
        this.idDiscipline = idDiscipline;
        this.balls = balls;
    }


    public Balls() {
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "idStudent")
    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    @Column(name = "idDiscipline")
    public int getIdDiscipline() {
        return idDiscipline;
    }

    public void setIdDiscipline(int idDiscipline) {
        this.idDiscipline = idDiscipline;
    }

    @Column(name = "balls")
    public int getBalls() {
        return balls;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }
}
