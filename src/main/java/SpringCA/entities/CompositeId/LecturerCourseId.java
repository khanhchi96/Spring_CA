package SpringCA.entities.CompositeId;

import java.io.Serializable;

public class LecturerCourseId implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private int lecturerByCourse;

    private int courseByLecturer;

    private int semesterLecturerCourse;

    public LecturerCourseId() {}

    public LecturerCourseId(int lecturerByCourse, int courseByLecturer, int semesterLecturerCourse) {
        this.lecturerByCourse = lecturerByCourse;
        this.courseByLecturer = courseByLecturer;
        this.semesterLecturerCourse = semesterLecturerCourse;
    }

    public int getLecturerByCourse() {
        return lecturerByCourse;
    }

    public void setLecturerByCourse(int lecturerByCourse) {
        this.lecturerByCourse = lecturerByCourse;
    }

    public int getCourseByLecturer() {
        return courseByLecturer;
    }

    public void setCourseByLecturer(int courseByLecturer) {
        this.courseByLecturer = courseByLecturer;
    }

    public int getSemesterLecturerCourse() {
        return semesterLecturerCourse;
    }

    public void setSemesterLecturerCourse(int semesterLecturerCourse) {
        this.semesterLecturerCourse = semesterLecturerCourse;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result+ lecturerByCourse;
        result = prime * result + courseByLecturer;
        result = prime * result + semesterLecturerCourse;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        LecturerCourseId other = (LecturerCourseId) obj;
        if (lecturerByCourse != other.lecturerByCourse)
            return false;
        if (courseByLecturer != other.courseByLecturer)
            return false;
        if (semesterLecturerCourse != other.semesterLecturerCourse)
            return false;
        return true;
    }
}
