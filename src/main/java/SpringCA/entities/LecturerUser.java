package SpringCA.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
public class LecturerUser extends User implements Serializable {

    @OneToOne
    @JoinColumn(name = "lecturer_id")
    private Lecturer lecturerUser;

    public LecturerUser() {
    }

    public LecturerUser(String username, String password, Lecturer lecturerUser) {
        super(username, password);
        this.lecturerUser = lecturerUser;
    }

    public Lecturer getLecturerUser() {
        return lecturerUser;
    }

    public void setLecturerUser(Lecturer lecturerUser) {
        this.lecturerUser = lecturerUser;
    }

    @Override
    public String getRole() {
        return "LECTURER";
    }
}
