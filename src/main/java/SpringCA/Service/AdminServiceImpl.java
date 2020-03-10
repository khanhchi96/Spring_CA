package SpringCA.Service;

import SpringCA.Repository.*;
import SpringCA.entities.CompositeId.LecturerLeaveId;
import SpringCA.entities.CompositeId.StudentCourseId;
import SpringCA.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
public class AdminServiceImpl implements AdminService {
    private StudentCourseRepository studentCourseRepository;
    private StudentRepository studentRepository;
    private EmailServiceImpl emailService;
    private CourseRepository courseRepository;
    private StudentUserRepository studentUserRepository;
    private LecturerCourseRepository lecturerCourseRepository;
    private LecturerRepository lecturerRepository;
    private LecturerUserRepository lecturerUserRepository;
    private LecturerLeaveRepository lecturerLeaveRepository;

    @Autowired
    public AdminServiceImpl(StudentCourseRepository studentCourseRepository, LecturerRepository lecturerRepository,
                            StudentRepository studentRepository, LecturerCourseRepository lecturerCourseRepository,
                            EmailServiceImpl emailService, StudentUserRepository studentUserRepository,
                            CourseRepository courseRepository, LecturerUserRepository lecturerUserRepository,
                            LecturerLeaveRepository lecturerLeaveRepository) {
        this.studentCourseRepository = studentCourseRepository;
        this.studentRepository = studentRepository;
        this.emailService = emailService;
        this.courseRepository = courseRepository;
        this.studentUserRepository = studentUserRepository;
        this.lecturerCourseRepository = lecturerCourseRepository;
        this.lecturerRepository = lecturerRepository;
        this.lecturerLeaveRepository = lecturerLeaveRepository;
        this.lecturerUserRepository = lecturerUserRepository;
    }

    public void reviewCourse(int studentId, int semesterId, int courseId, String action) {
        StudentCourseId studentCourseId = new StudentCourseId(studentId, courseId, semesterId);
        StudentCourse studentCourse = studentCourseRepository.findById(studentCourseId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid object"));
        if (action.equals("approve")) studentCourse.setStatus("Approved");
        if (action.equals("reject")) studentCourse.setStatus("Rejected");
        studentCourseRepository.save(studentCourse);
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id" + studentId));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid course Id" + studentId));
        String url = "http://localhost:8080/student/";
        if (action.equals("approve")) url += "courseEnrolled/";
        else url += "rejectedCourse";
        String mailSubject = "COURSE REGISTRATION RESULT: " + course.getCourseCode() + " - " + course.getCourseName().toUpperCase();
        String text = "Dear student,\nYour registration for the course " + course.getCourseCode() +
                " - " + course.getCourseName() + " has been " + studentCourse.getStatus().toLowerCase()
                + ". You can view the result via this link: " + url + ".\nThank you!\nXoxo,\nGossip girl";
        emailService.sendSimpleMessage(new String[]{student.getEmail()}, mailSubject, text);
    }

    public void reviewLeave(int lecturerId, Date date, String action) {
        SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");
        LecturerLeaveId lecturerLeaveId = new LecturerLeaveId(lecturerId, date);
        LecturerLeave lecturerLeave = lecturerLeaveRepository.findById(lecturerLeaveId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid"));
        String url = "http://localhost:8080/lecturer/leave/";
        if (action.equals("approve")) {
            lecturerLeave.setStatus("Approved");
            url += "list";
        }
        if (action.equals("reject")) {
            lecturerLeave.setStatus("Rejected");
            url += "rejected/list";
        }
        lecturerLeaveRepository.save(lecturerLeave);
        Lecturer lecturer = lecturerRepository.findById(lecturerId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid lecturer Id" + lecturerId));
        String mailSubject = "LECTURER LEAVE REQUEST REVIEW - " + lecturer.toString().toUpperCase();
        String text = "Dear " + lecturer.toString().toUpperCase() + ",\nYour request for leave from " +
                formatter2.format(lecturerLeave.getStartDate()) + " to " +
                formatter2.format(lecturerLeave.getEndDate()) + " have been " +
                lecturerLeave.getStatus().toLowerCase() + ". You can view the result via this link: " + url +
                "\nThank you!\nXoxo,\nGossip girl";
        emailService.sendSimpleMessage(new String[]{lecturer.getEmail()}, mailSubject, text);
    }

    public void deleteStudent(int id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        StudentUser studentUser = studentUserRepository.findByStudentUser_StudentId(id);
        studentUserRepository.delete(studentUser);
        Iterable<StudentCourse> studentCourses = studentCourseRepository.findByStudentByCourse_StudentId(id);
        for (StudentCourse s : studentCourses) studentCourseRepository.delete(s);
        studentRepository.delete(student);
    }

    public void deleteCourse(int id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid course Id:" + id));
        Iterable<StudentCourse> studentCourses = studentCourseRepository.findByCourseByStudent_CourseId(id);
        Iterable<LecturerCourse> lecturerCourses = lecturerCourseRepository.findByCourseByLecturer_CourseId(id);
        for (StudentCourse s : studentCourses) studentCourseRepository.delete(s);
        for (LecturerCourse l : lecturerCourses) lecturerCourseRepository.delete(l);
        courseRepository.delete(course);
    }

    public void deleteLecturer(int id) {
        Lecturer lecturer = lecturerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid lecturer Id:" + id));
        LecturerUser lecturerUser = lecturerUserRepository.findByLecturerUser_LecturerId(id);
        lecturerUserRepository.delete(lecturerUser);
        Iterable<LecturerLeave> lecturerLeaves = lecturerLeaveRepository.findByLecturerByLeave_LecturerId(id);
        for (LecturerLeave l : lecturerLeaves) lecturerLeaveRepository.delete(l);
        Iterable<LecturerCourse> lecturerCourses = lecturerCourseRepository.findByLecturerByCourse_LecturerId(id);
        for (LecturerCourse l : lecturerCourses) lecturerCourseRepository.delete(l);
        lecturerRepository.delete(lecturer);
    }

    public Set<Semester> getSemestersForCourse(int id) {
        Iterable<LecturerCourse> lecturerCourses = lecturerCourseRepository.findByCourseByLecturer_CourseId(id);
        Set<Semester> semesters = new HashSet<>();
        for (LecturerCourse s : lecturerCourses)
            semesters.add(s.getSemesterLecturerCourse());
        return semesters;
    }

    public long getLastPage(long count, int size) {
        if (count % size == 0) return count / size;
        else return ((long) Math.floor(count / size) + 1);
    }
}
