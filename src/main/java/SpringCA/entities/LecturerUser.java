package SpringCA.entities;

import SpringCA.entities.CompositeId.UserId;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class LecturerUser extends User implements Serializable{

    @OneToOne
    @JoinColumn(name = "lecturer_id")
    @MapsId("user")
    private Lecturer lecturerUser;

    public LecturerUser(){}

    public LecturerUser(UserId studentUserId, String password) {
        super(studentUserId, password);
    }
}
