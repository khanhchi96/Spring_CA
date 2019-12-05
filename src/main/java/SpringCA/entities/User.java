package SpringCA.entities;

import SpringCA.entities.CompositeId.UserId;

import javax.persistence.EmbeddedId;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class User {
    @EmbeddedId
    private UserId userId;

    private String password;

    public User(){}

    public User(UserId userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public UserId getUserId() {
        return userId;
    }

    public void setUserId(UserId userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
