package SpringCA.entities;

import SpringCA.entities.CompositeId.UserId;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class StudentUser extends User implements Serializable{

    @OneToOne
    @JoinColumn(name = "student_id")
    @MapsId("user")
    private Student studentUser;

    public StudentUser(){}

    public StudentUser(UserId studentUserId, String password) {
        super(studentUserId, password);
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
