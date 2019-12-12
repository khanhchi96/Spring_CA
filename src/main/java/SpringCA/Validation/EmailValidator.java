package SpringCA.Validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<EmailConstraint, String> {
    @Override
    public void initialize(EmailConstraint email) {
    }

    @Override
    public boolean isValid(String email,
                           ConstraintValidatorContext cxt) {
        return email != null && email.matches("^[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."+
                "[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+(?:[a-zA-Z]{2}"+
                "|aero|asia|biz|cat|com|coop|edu|gov|info|int|jobs|mil|mobi|museum|name|net|org|pro|tel|travel)$");
    }
}
