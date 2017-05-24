
package balls.model;

import javax.persistence.*;

@Entity
@Table(name = "discipline", schema = "students", catalog = " ")
public class Discipline extends Professors {
    private int id;
    private String nameDiscipline;
    private int idProfessor;

    public Discipline(int id, String nameDiscipline, int idProfessor) {
        this.id = id;
        this.nameDiscipline = nameDiscipline;
        this.idProfessor = idProfessor;
    }

    public Discipline() {
    }

    public Discipline(int id, String familyProfessors, String nameProfessors, String nameFatherProfessors, int id1, String nameDiscipline, int idProfessor) {
        super(id, familyProfessors, nameProfessors, nameFatherProfessors);
        this.id = id1;
        this.nameDiscipline = nameDiscipline;
        this.idProfessor = idProfessor;
    }

    public Discipline(String nameDiscipline) {
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

    @Column(name = "nameDiscipline")
    public String getNameDiscipline() {
        return nameDiscipline;
    }

    public void setNameDiscipline(String nameDiscipline) {
        this.nameDiscipline = nameDiscipline;
    }

    @Column(name = "idProfessor")
    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }
}
