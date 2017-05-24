package balls.model;

import javax.persistence.*;

@Entity
@Table(name = "groups", schema = "students", catalog = " ")
public class Groups {
    private int id;
    private String nameGroup;

    public Groups(int id, String nameGroup) {
        this.id = id;
        this.nameGroup = nameGroup;
    }

    public Groups() {
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

    @Column(name = "nameGroup")
    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }
}
