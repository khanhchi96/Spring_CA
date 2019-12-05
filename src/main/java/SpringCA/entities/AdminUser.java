package SpringCA.entities;

import SpringCA.entities.CompositeId.UserId;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class AdminUser extends User implements Serializable{

    @OneToOne
    @JoinColumn(name = "admin_id")
    @MapsId("user")
    private Admin adminUser;

    public AdminUser(){}

    public AdminUser(UserId studentUserId, String password) {
        super(studentUserId, password);
    }
}
