package SpringCA.entities.CompositeId;

import java.io.Serializable;

public class StudentCourseId implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private int studentByCourse;

    private int courseByStudent;

    private int semesterStudentCourse;

    public StudentCourseId() {}

    public StudentCourseId(int studentByCourse, int courseByStudent, int semesterStudentCourse) {
        this.studentByCourse = studentByCourse;
        this.courseByStudent = courseByStudent;
        this.semesterStudentCourse = semesterStudentCourse;
    }

    public int getStudentByCourse() {
        return studentByCourse;
    }

    public void setStudentByCourse(int studentByCourse) {
        this.studentByCourse = studentByCourse;
    }

    public int getCourseByStudent() {
        return courseByStudent;
    }

    public void setCourseByStudent(int courseByStudent) {
        this.courseByStudent = courseByStudent;
    }

    public int getSemesterStudentCourse() {
        return semesterStudentCourse;
    }

    public void setSemesterStudentCourse(int semesterStudentCourse) {
        this.semesterStudentCourse = semesterStudentCourse;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result+ studentByCourse;
        result = prime * result + courseByStudent;
        result = prime * result + semesterStudentCourse;
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
        StudentCourseId other = (StudentCourseId) obj;
        if (studentByCourse != other.studentByCourse)
            return false;
        if (courseByStudent != other.courseByStudent)
            return false;
        if (semesterStudentCourse != other.semesterStudentCourse)
            return false;
        return true;
    }
}
