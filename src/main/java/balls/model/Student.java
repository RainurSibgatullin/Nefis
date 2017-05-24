package balls.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Student")
public class Student extends Groups {
    private int id;
    private String familyStudents;
    private String nameStudents;
    private String nameFatherStudents;
    private Date birthdate;
    private int idGroup;

    public Student(int id, String nameGroup) {
        super(id, nameGroup);
    }

    public Student(int id, String familyStudents, String nameStudents, String nameFatherStudents, Date birthdate, int idGroup) {
        this.id = id;
        this.familyStudents = familyStudents;
        this.nameStudents = nameStudents;
        this.nameFatherStudents = nameFatherStudents;
        this.birthdate = birthdate;
        this.idGroup = idGroup;
    }

    public Student(int id, String nameGroup, int id1, String familyStudents, String nameStudents, String nameFatherStudents, Date birthdate, int idGroup) {
        super(id, nameGroup);
        this.id = id1;
        this.familyStudents = familyStudents;
        this.nameStudents = nameStudents;
        this.nameFatherStudents = nameFatherStudents;
        this.birthdate = birthdate;
        this.idGroup = idGroup;
    }

    public Student() {
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

    @Column(name = "familyStudents")
    public String getFamilyStudents() {
        return familyStudents;
    }

    public void setFamilyStudents(String familyStudents) {
        this.familyStudents = familyStudents;
    }

    @Column(name = "nameStudents")
    public String getNameStudents() {
        return nameStudents;
    }

    public void setNameStudents(String nameStudents) {
        this.nameStudents = nameStudents;
    }

    @Column(name = "nameFatherStudents")
    public String getNameFatherStudents() {
        return nameFatherStudents;
    }

    public void setNameFatherStudents(String nameFatherStudents) {
        this.nameFatherStudents = nameFatherStudents;
    }

    @Column(name = "birthdate")
    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Column(name = "idGroup")
    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }
}
