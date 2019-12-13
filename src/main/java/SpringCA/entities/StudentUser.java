package SpringCA.entities;

import SpringCA.entities.CompositeId.UserId;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class StudentUser extends User{

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student studentUser;

    public StudentUser(){}

    public StudentUser(String username, String password, Student studentUser) {
        super(username, password);
        this.studentUser = studentUser;
    }

    public Student getStudentUser() {
        return studentUser;
    }

    public void setStudentUser(Student studentUser) {
        this.studentUser = studentUser;
    }

    @Override
    public String getRole(){
        return "STUDENT";
    }
}
