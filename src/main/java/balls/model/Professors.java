package balls.model;

import javax.persistence.*;

@Entity
@Table(name = "professors", schema = "students", catalog = " ")
public class Professors {
    private int id;
    private String familyProfessors;
    private String nameProfessors;
    private String nameFatherProfessors;

    public Professors(int id, String familyProfessors, String nameProfessors, String nameFatherProfessors) {
        this.id = id;
        this.familyProfessors = familyProfessors;
        this.nameProfessors = nameProfessors;
        this.nameFatherProfessors = nameFatherProfessors;
    }

    public Professors() {
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

    @Column(name = "familyProfessors")
    public String getFamilyProfessors() {
        return familyProfessors;
    }

    public void setFamilyProfessors(String familyProfessors) {
        this.familyProfessors = familyProfessors;
    }

    @Column(name = "nameProfessors")
    public String getNameProfessors() {
        return nameProfessors;
    }

    public void setNameProfessors(String nameProfessors) {
        this.nameProfessors = nameProfessors;
    }

    @Column(name = "nameFatherProfessors")
    public String getNameFatherProfessors() {
        return nameFatherProfessors;
    }

    public void setNameFatherProfessors(String nameFatherProfessors) {
        this.nameFatherProfessors = nameFatherProfessors;
    }
}