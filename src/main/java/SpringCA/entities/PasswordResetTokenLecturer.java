package SpringCA.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class PasswordResetTokenLecturer extends PasswordResetToken {
    @OneToOne(targetEntity = LecturerUser.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "lecturer_username")
    private LecturerUser lecturerUser;

    public PasswordResetTokenLecturer() {
    }

    public PasswordResetTokenLecturer(String token, LecturerUser lecturerUser) {
        super(token);
        this.lecturerUser = lecturerUser;
    }

    public LecturerUser getLecturerUser() {
        return lecturerUser;
    }

    public void setLecturerUser(LecturerUser lecturerUser) {
        this.lecturerUser = lecturerUser;
    }
}
