package SpringCA.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Degree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int degreeId;
    private String degreeLabel;

    @OneToMany(mappedBy = "degree")
    private List<Student> students;

    public Degree() {
    }

    public Degree(String degreeLabel) {
        this.degreeLabel = degreeLabel;
    }

    public int getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(int degreeId) {
        this.degreeId = degreeId;
    }

    public String getDegreeLabel() {
        return degreeLabel;
    }

    public void setDegreeLabel(String degreeLabel) {
        this.degreeLabel = degreeLabel;
    }
}
