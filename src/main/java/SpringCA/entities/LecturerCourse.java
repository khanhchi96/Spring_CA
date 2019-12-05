package SpringCA.entities;

import SpringCA.entities.CompositeId.LecturerCourseId;

import javax.persistence.*;

@Entity
@IdClass(LecturerCourseId.class)
public class LecturerCourse {
    @Id
    @ManyToOne
    @JoinColumn(name = "lecturerId")
    private Lecturer lecturerByCourse;

    @Id
    @ManyToOne
    @JoinColumn(name = "courseId")
    private Course courseByLecturer;

    @Id
    @ManyToOne
    @JoinColumn(name = "semesterId")
    private Semester semesterLecturerCourse;

    public LecturerCourse(){}

    public LecturerCourse(Lecturer lecturerByCourse, Course courseByLecturer, Semester semesterLecturerCourse) {
        this.lecturerByCourse = lecturerByCourse;
        this.courseByLecturer = courseByLecturer;
        this.semesterLecturerCourse = semesterLecturerCourse;
    }

    public Lecturer getLecturerByCourse() {
        return lecturerByCourse;
    }

    public void setLecturerByCourse(Lecturer lecturerByCourse) {
        this.lecturerByCourse = lecturerByCourse;
    }

    public Course getCourseByLecturer() {
        return courseByLecturer;
    }

    public void setCourseByLecturer(Course courseByLecturer) {
        this.courseByLecturer = courseByLecturer;
    }

    public Semester getSemesterLecturerCourse() {
        return semesterLecturerCourse;
    }

    public void setSemesterLecturerCourse(Semester semesterLecturerCourse) {
        this.semesterLecturerCourse = semesterLecturerCourse;
    }
}
