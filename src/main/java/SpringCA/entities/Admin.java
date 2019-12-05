package SpringCA.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Admin extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adminId;

    @OneToOne(mappedBy = "adminUser")
    private AdminUser adminUser;

    public Admin(){}

    public Admin(String firstName, String middleName, String lastName, String gender, LocalDateTime birthDate,
                 String address, String email, String mobile) {
        super(firstName, middleName, lastName, gender, birthDate, address, email, mobile);
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }
}
