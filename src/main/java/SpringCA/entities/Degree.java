package SpringCA.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Degree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int degreeId;
    private String degree_label;

    @OneToMany(mappedBy = "degree")
    private List<Student> students;

    public Degree(){}

    public Degree(String degree_label) {
        this.degree_label = degree_label;
    }

    public int getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(int degreeId) {
        this.degreeId = degreeId;
    }

    public String getDegree_label() {
        return degree_label;
    }

    public void setDegree_label(String degree_label) {
        this.degree_label = degree_label;
    }
}
