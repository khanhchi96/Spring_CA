package SpringCA.model;

import SpringCA.Validation.FieldMatchConstraint;

import javax.validation.constraints.NotEmpty;

@FieldMatchConstraint(first = "password", second = "confirmPassword", message = "Passwords must match")
public class ResetPassword {
    @NotEmpty(message = "Password must not be empty")
    private String password;

    @NotEmpty(message = "You must confirm password")
    private String confirmPassword;

    public ResetPassword(String password, String confirmPassword) {
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
