package SpringCA.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class PasswordResetTokenAdmin extends PasswordResetToken {
    @OneToOne(targetEntity = AdminUser.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "admin_username")
    private AdminUser adminUser;

    public PasswordResetTokenAdmin() {
    }

    public PasswordResetTokenAdmin(String token, AdminUser adminUser) {
        super(token);
        this.adminUser = adminUser;
    }

    public AdminUser getAdminUser() {
        return adminUser;
    }

    public void setAdminUser(AdminUser adminUser) {
        this.adminUser = adminUser;
    }
}
