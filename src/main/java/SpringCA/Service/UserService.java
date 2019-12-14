package SpringCA.Service;

import SpringCA.Repository.*;
import SpringCA.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    @Autowired
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private EmailServiceImpl emailServiceImpl;
    private PasswordResetTokenStudentRepository tokenStudentRepository;
    private StudentUserRepository studentUserRepository;
    private LecturerUserRepository lecturerUserRepository;
    private PasswordResetTokenLecturerRepository tokenLecturerRepository;
    private PasswordResetTokenAdminRepository tokenAdminRepository;
    private AdminUserRepository adminUserRepository;

    @Autowired
    public UserService(EmailServiceImpl emailServiceImpl, PasswordResetTokenStudentRepository tokenStudentRepository,
                       StudentUserRepository studentUserRepository, LecturerUserRepository lecturerUserRepository,
                       AdminUserRepository adminUserRepository, PasswordResetTokenLecturerRepository tokenLecturerRepository,
                       PasswordResetTokenAdminRepository tokenAdminRepository) {
        this.emailServiceImpl = emailServiceImpl;
        this.tokenStudentRepository = tokenStudentRepository;
        this.tokenLecturerRepository = tokenLecturerRepository;
        this.tokenAdminRepository = tokenAdminRepository;
        this.studentUserRepository = studentUserRepository;
        this.lecturerUserRepository = lecturerUserRepository;
        this.adminUserRepository = adminUserRepository;
    }

    public void setStudentUser(Student student) {
        StudentUser studentUser = new StudentUser();
        studentUser.setUsername("S" + setUsername(student.getStudentId()));
        studentUser.setStudentUser(student);
        String password = getAlphaNumericString();
        System.out.println(password);
        studentUser.setPassword(passwordEncoder().encode(password));
        String text = "Dear student,\nThis is your student user credentials:\nYour username: " + "S" + setUsername(student.getStudentId()) + "\nYour password: " + password
                + "\nPlease use them to login to ISS system.\nXoxo,\nGossip girl";
        emailServiceImpl.sendSimpleMessage(new String[]{student.getEmail()}, "ISS MANAGEMENT SYSTEM - USER REGISTRATION", text);
        studentUserRepository.save(studentUser);
    }

    public void setLecturerUser(Lecturer lecturer) {
        LecturerUser lecturerUser = new LecturerUser();
        lecturerUser.setUsername("L" + setUsername(lecturer.getLecturerId()));
        lecturerUser.setLecturerUser(lecturer);
        String password = getAlphaNumericString();
        System.out.println(password);
        lecturerUser.setPassword(passwordEncoder().encode(password));
        lecturerUserRepository.save(lecturerUser);
    }

    public String getUsername(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        return username;
    }

    private String setUsername(int studentId) {
        String str = "0000000";
        String id = String.valueOf(studentId);
        str = str.substring(0, str.length() - id.length());
        return str + studentId;
    }

    private String getAlphaNumericString() {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(8);

        for (int i = 0; i < 8; i++) {
            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());
            sb.append(AlphaNumericString
                    .charAt(index));
        }
        return sb.toString();
    }


    public void createPasswordResetTokenForStudent(StudentUser studentUser, String token) {
        String url = constructResetTokenUrl(token, studentUser, "student");
        PasswordResetTokenStudent myToken = new PasswordResetTokenStudent(token, studentUser);
        tokenStudentRepository.save(myToken);
        emailServiceImpl.sendSimpleMessage(new String[]{studentUser.getStudentUser().getEmail()}, "RESET PASSWORD", url);
    }

    public void createPasswordResetTokenForLecturer(LecturerUser lecturerUser, String token) {
        String url = constructResetTokenUrl(token, lecturerUser, "lecturer");
        PasswordResetTokenLecturer myToken = new PasswordResetTokenLecturer(token, lecturerUser);
        tokenLecturerRepository.save(myToken);
        emailServiceImpl.sendSimpleMessage(new String[]{lecturerUser.getLecturerUser().getEmail()}, "RESET PASSWORD", url);
    }

    public void createPasswordResetTokenForAdmin(AdminUser adminUser, String token) {
        String url = constructResetTokenUrl(token, adminUser, "admin");
        PasswordResetTokenAdmin myToken = new PasswordResetTokenAdmin(token, adminUser);
        tokenAdminRepository.save(myToken);
        emailServiceImpl.sendSimpleMessage(new String[]{adminUser.getAdminUser().getEmail()}, "RESET PASSWORD", url);
    }

    public void resetStudentPassword(String username, String password) {
        StudentUser studentUser = studentUserRepository.findByUsername(username);
        studentUser.setPassword(passwordEncoder().encode(password));
        studentUserRepository.save(studentUser);
    }

    public void resetLecturerPassword(String username, String password) {
        LecturerUser lecturerUser = lecturerUserRepository.findByUsername(username);
        lecturerUser.setPassword(passwordEncoder().encode(password));
        lecturerUserRepository.save(lecturerUser);
    }

    public void resetAdminPassword(String username, String password) {
        AdminUser adminUser = adminUserRepository.findByUsername(username);
        adminUser.setPassword(passwordEncoder().encode(password));
        adminUserRepository.save(adminUser);
    }

    private String constructResetTokenUrl(String token, User user, String id) {
        String url = "http://localhost:8080/resetPassword/" + id + "/" +
                user.getUsername() + "/" + token;
        return url;
    }

}
