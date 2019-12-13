package SpringCA.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class PasswordResetTokenStudent extends PasswordResetToken {

    @OneToOne(targetEntity = StudentUser.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "student_username")
    private StudentUser studentUser;

    public PasswordResetTokenStudent(){}

    public PasswordResetTokenStudent(String token, StudentUser studentUser) {
        super(token);
        this.studentUser = studentUser;
    }
}
