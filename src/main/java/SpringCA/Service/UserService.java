package SpringCA.Service;

import SpringCA.entities.CompositeId.UserId;
import SpringCA.entities.Lecturer;
import SpringCA.entities.LecturerUser;
import SpringCA.entities.Student;
import SpringCA.entities.StudentUser;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public UserService(EmailServiceImpl emailServiceImpl) {
        this.emailServiceImpl = emailServiceImpl;
    }

    public StudentUser setStudentUser(Student student) {
        StudentUser studentUser = new StudentUser();
        studentUser.setUserId(new UserId("S" + setUsername(student.getStudentId()), student.getStudentId()));
        studentUser.setStudentUser(student);
        String password = getAlphaNumericString();
        System.out.println(password);
        studentUser.setPassword(passwordEncoder().encode(password));
        String text = "Dear student,\nThis is your student user credentials:\nYour username: " + "S" + setUsername(student.getStudentId()) + "\nYour password: " + password
                + "\nPlease use them to login to ISS system.\nXoxo,\nGossip girl";
        emailServiceImpl.sendSimpleMessage(student.getEmail(), "ISS MANAGEMENT SYSTEM - USER REGISTRATION", text);
        return studentUser;
    }

    public LecturerUser setLecturerUser(Lecturer lecturer) {
        LecturerUser lecturerUser = new LecturerUser();
        lecturerUser.setUserId(new UserId("L" + setUsername(lecturer.getLecturerId()), lecturer.getLecturerId()));
        lecturerUser.setLecturerUser(lecturer);
        String password = getAlphaNumericString();
        System.out.println(password);
        lecturerUser.setPassword(passwordEncoder().encode(password));
        return lecturerUser;
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

}
