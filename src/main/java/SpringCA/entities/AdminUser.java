package SpringCA.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
public class AdminUser extends User implements Serializable {

    @OneToOne
    @JoinColumn(name = "admin_id")
    private Admin adminUser;

    public AdminUser() {
    }

    public AdminUser(String username, String password, Admin adminUser) {
        super(username, password);
        this.adminUser = adminUser;
    }

    @Override
    public String getRole() {
        return "ADMIN";
    }

    public Admin getAdminUser() {
        return adminUser;
    }

    public void setAdminUser(Admin adminUser) {
        this.adminUser = adminUser;
    }
}
