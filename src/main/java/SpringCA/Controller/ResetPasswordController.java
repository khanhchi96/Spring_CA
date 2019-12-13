package SpringCA.Controller;

import SpringCA.Repository.PasswordResetTokenStudentRepository;
import SpringCA.Repository.StudentUserRepository;
import SpringCA.Service.EmailServiceImpl;
import SpringCA.Service.UserService;
import SpringCA.entities.PasswordResetTokenStudent;
import SpringCA.entities.StudentUser;
import SpringCA.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.Duration;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("/resetPassword")
public class ResetPasswordController {

    @Autowired
    StudentUserRepository studentUserRepository;

    @Autowired
    PasswordResetTokenStudentRepository passwordResetTokenStudentRepository;


    @Autowired
    UserService userService;

    @Autowired
    EmailServiceImpl emailServiceImpl;
    @GetMapping(value = "/student/{username}")
    public String getResetPasswordUrl(HttpServletRequest request, @PathVariable("username") String username) {
        StudentUser studentUser = studentUserRepository.findByUsername(username);
        String token = UUID.randomUUID().toString();
        userService.createPasswordResetTokenForUser(studentUser, token);
        String url = constructResetTokenUrl(token, studentUser);
        emailServiceImpl.sendSimpleMessage(new String[] {studentUser.getStudentUser().getEmail()}, "RESET PASSWORD", url);
        return "resetPasswordUrl";
    }

    @GetMapping(value = "/student/{username}/{token}")
    public String resetPassword(@PathVariable("username") String username, @PathVariable("token") String token,
                                Model model){
        Iterable<PasswordResetTokenStudent> tokenStudents = passwordResetTokenStudentRepository.findByStudentUser_Username(username);
        for(PasswordResetTokenStudent s: tokenStudents){
            if(s.getToken().equals(token) && s.getExpiryDate().after(new Date())){
                return "resetPassword";
            }
        }


        return "expiredLink";
    }


    private String constructResetTokenUrl(String token, User user) {
        String url = "http://localhost:8080/resetPassword/student/" +
                user.getUsername() + "/" + token;
        return url;
    }
}
