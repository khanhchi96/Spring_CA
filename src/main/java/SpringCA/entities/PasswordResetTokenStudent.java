package SpringCA.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class PasswordResetTokenStudent extends PasswordResetToken {

    @OneToOne(targetEntity = StudentUser.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "student_username")
    private StudentUser studentUser;

    public PasswordResetTokenStudent() {
    }

    public PasswordResetTokenStudent(String token, StudentUser studentUser) {
        super(token);
        this.studentUser = studentUser;
    }

    public StudentUser getStudentUser() {
        return studentUser;
    }

    public void setStudentUser(StudentUser studentUser) {
        this.studentUser = studentUser;
    }
}
