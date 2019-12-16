package SpringCA.csv;

import SpringCA.Repository.LecturerCourseRepository;
import SpringCA.Repository.StudentCourseRepository;
import SpringCA.entities.LecturerCourse;
import SpringCA.entities.StudentCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;


@Component
public class CsvWriter {
    private LecturerCourseRepository lecturerCourseRepository;
    private StudentCourseRepository studentCourseRepository;

    @Autowired
    public CsvWriter(LecturerCourseRepository lecturerCourseRepository, StudentCourseRepository studentCourseRepository) {
        this.lecturerCourseRepository = lecturerCourseRepository;
        this.studentCourseRepository = studentCourseRepository;
    }

    public void writeCsv(int courseId, int semesterId, HttpServletResponse response) throws IOException {
        Iterable<LecturerCourse> lecturerCourses =
                lecturerCourseRepository.findByCourseByLecturer_CourseIdAndSemesterLecturerCourse_SemesterId(courseId, semesterId);
        Iterable<StudentCourse> studentCourses =
                studentCourseRepository.findByCourseByStudent_CourseIdAndSemesterStudentCourse_SemesterIdAndStatus(courseId, semesterId, "Approved");

        LecturerCourse firstElement = lecturerCourses.iterator().next();

        String csvFileName = firstElement.getSemesterLecturerCourse().getSemesterLabel() +
                firstElement.getCourseByLecturer().getCourseName() + ".csv";
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + csvFileName + "\"");
        try {
            OutputStream o = response.getOutputStream();
            String courseName = firstElement.getCourseByLecturer().getCourseCode() + " - " + firstElement.getCourseByLecturer().getCourseName() + "\n";
            String header1 = "List of lecturers: \n \n";
            String header2 = "Lecturer name, Department\n";
            o.write(courseName.getBytes());
            o.write(header1.getBytes());
            o.write(header2.getBytes());

            for (LecturerCourse c : lecturerCourses) {
                String newStr = c.getLecturerByCourse().getFirstName() + "," + c.getLecturerByCourse().getDepartmentLecturer().getDepartmentName() + "\n";
                o.write(newStr.getBytes());
            }
            String header3 = "\nList of students\n";
            String header4 = "StudentId, Name, Email, Score\n";
            o.write(header3.getBytes());
            o.write(header4.getBytes());
            for (StudentCourse c : studentCourses) {
                String newStr = c.getStudentByCourse().getStudentId() + "," +
                        c.getStudentByCourse().getFirstName() + "," +
                        c.getStudentByCourse().getEmail() + "," + c.getScore() + "\n";
                o.write(newStr.getBytes());
            }
            o.flush();


        } catch (Exception e) {
            throw new IOException("Error!");
        }

    }
}
