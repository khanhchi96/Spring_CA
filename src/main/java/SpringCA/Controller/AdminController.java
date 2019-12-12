package SpringCA.Controller;

import SpringCA.Repository.*;
import SpringCA.Service.UserService;
import SpringCA.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private StudentRepository studentRepository;
    private SemesterRepository semesterRepository;
    private DegreeRepository degreeRepository;
    private CourseRepository courseRepository;
    private LecturerRepository lecturerRepository;
    private LecturerCourseRepository lecturerCourseRepository;
    private StudentCourseRepository studentCourseRepository;
    private DepartmentRepository departmentRepository;
    private StudentUserRepository studentUserRepository;
    private LecturerUserRepository lecturerUserRepository;
    private UserService userService;

    @Autowired
    SpringCA.csvWriter.CsvWriter csvWriter;

    @Autowired
    public AdminController(StudentRepository studentRepository, SemesterRepository semesterRepository,
                           DegreeRepository degreeRepository, CourseRepository courseRepository,
                           LecturerRepository lecturerRepository, LecturerCourseRepository lecturerCourseRepository,
                           StudentCourseRepository studentCourseRepository, DepartmentRepository departmentRepository,
                           StudentUserRepository studentUserRepository, LecturerUserRepository lecturerUserRepository, UserService userService) {
        this.studentRepository = studentRepository;
        this.semesterRepository = semesterRepository;
        this.degreeRepository = degreeRepository;
        this.courseRepository = courseRepository;
        this.lecturerRepository = lecturerRepository;
        this.lecturerCourseRepository = lecturerCourseRepository;
        this.studentCourseRepository = studentCourseRepository;
        this.departmentRepository = departmentRepository;
        this.studentUserRepository = studentUserRepository;
        this.lecturerUserRepository = lecturerUserRepository;
        this.userService = userService;
    }


    @ModelAttribute(name = "semesters")
    public Iterable<Semester> getSemesters() {
        return semesterRepository.findAll();
    }

    @ModelAttribute(name = "degrees")
    public Iterable<Degree> getDegrees() {
        return degreeRepository.findAll();
    }

    @ModelAttribute(name = "students")
    public Iterable<Student> getStudents() {
        return studentRepository.findAll();
    }

    @ModelAttribute(name = "courses")
    public Iterable<Course> getCourses() {
        return courseRepository.findAll();
    }

    @ModelAttribute(name = "lecturers")
    public Iterable<Lecturer> getLecturers() {
        return lecturerRepository.findAll();
    }

    @ModelAttribute(name = "departments")
    public Iterable<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @GetMapping("/student/list")
    public String studentList() {
        return "admin/studentList";
    }

    @GetMapping("/course/list")
    public String courseList() {
        return "admin/courseList";
    }

    @GetMapping("/lecturer/list")
    public String lecturerList() {
        return "admin/lecturerList";
    }

    @GetMapping("/student/addStudent")
    public String addStudent(Student student, Model model) {
        model.addAttribute("id", 0);
        return "admin/studentForm";
    }

    @GetMapping("/course/addCourse")
    public String addCourse(Course course, Model model) {
        model.addAttribute("id", 0);
        return "admin/courseForm";
    }

    @GetMapping("/student/addLecturer")
    public String addLecturer(Lecturer lecturer, Model model) {
        model.addAttribute("id", 0);
        return "admin/lecturerForm";
    }

//    @RequestMapping(value = "/admin/student/addStudent", method = RequestMethod.POST)
//    public String addStudent(@Valid Student student, BindingResult result, Model model ){
//        if(result.hasErrors()) {
//            return "admin/studentForm";
//        }
//        studentRepository.save(student);
//        model.addAttribute("students", studentRepository.findAll());
//        return "redirect:/admin/student/list";
//    }

    @GetMapping("/student/edit/{id}")
    public String updateStudent(@PathVariable("id") int id, Model model) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("student", student);
        model.addAttribute("id", id);
        return "admin/studentForm";
    }

    @GetMapping("/course/edit/{id}")
    public String updateCourse(@PathVariable("id") int id, Model model) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid course Id:" + id));

        model.addAttribute("course", course);
        model.addAttribute("id", id);
        return "admin/courseForm";
    }

    @GetMapping("/lecturer/edit/{id}")
    public String updateLecturer(@PathVariable("id") int id, Model model) {
        Lecturer lecturer = lecturerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid lecturer Id:" + id));

        model.addAttribute("lecturer", lecturer);
        model.addAttribute("id", id);
        return "admin/lecturerForm";
    }

    @PostMapping("/student/save/{id}")
    public String updateStudent(@PathVariable("id") int id, @Valid Student student,
                                BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("id", id);
            return "admin/studentForm";
        }
        if (id != 0) student.setStudentId(id);
        studentRepository.save(student);
        if (id == 0) studentUserRepository.save(userService.setStudentUser(student));
        return "redirect:/admin/student/list";
    }

    @PostMapping("/course/save/{id}")
    public String updateCourse(@PathVariable("id") int id, @Valid Course course,
                               BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("id", id);
            return "admin/courseForm";
        }
        if (id != 0) course.setCourseId(id);
        courseRepository.save(course);
        return "redirect:/admin/course/list";
    }

    @PostMapping("/lecturer/save/{id}")
    public String updateLecturer(@PathVariable("id") int id, @Valid Lecturer lecturer,
                                 BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("id", id);
            return "admin/lecturerForm";
        }
        if (id != 0) lecturer.setLecturerId(id);
        lecturerRepository.save(lecturer);
        if (id == 0) lecturerUserRepository.save(userService.setLecturerUser(lecturer));
        return "redirect:/admin/lecturer/list";
    }

    @GetMapping("/student/delete/{id}")
    public String deleteStudent(@PathVariable("id") int id, Model model) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        studentRepository.delete(student);
        studentUserRepository.delete(studentUserRepository.findByUserId_User(id));
        return "redirect:/admin/student/list";
    }

    @GetMapping("/course/delete/{id}")
    public String deleteCourse(@PathVariable("id") int id, Model model) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid course Id:" + id));
        courseRepository.delete(course);
        return "redirect:/admin/course/list";
    }

    @GetMapping("/lecturer/delete/{id}")
    public String deleteLecturer(@PathVariable("id") int id) {
        Lecturer lecturer = lecturerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid lecturer Id:" + id));
        lecturerRepository.delete(lecturer);
        lecturerUserRepository.delete(lecturerUserRepository.findByUserId_User(id));
        return "redirect:/admin/lecturer/list";
    }

    @GetMapping("/course/detail/{id}")
    public String getCourseSemesters(@PathVariable("id") int id, Model model) {
        Iterable<LecturerCourse> lecturerCourses = lecturerCourseRepository.findByCourseByLecturer_CourseId(id);
        Set<Semester> semesters = new HashSet<>();
        for (LecturerCourse s : lecturerCourses)
            semesters.add(s.getSemesterLecturerCourse());
        Course course = courseRepository.findByCourseId(id);
        model.addAttribute("courseSemesters", semesters);
        model.addAttribute("course", course);
        return "admin/course-semester";
    }

    @GetMapping("/course/detail/{courseId}/{semesterId}")
    public String getCourseDetails(@PathVariable("courseId") int courseId,
                                   @PathVariable("semesterId") int semesterId, Model model) {
        Iterable<LecturerCourse> lecturerCourses =
                lecturerCourseRepository.findByCourseByLecturer_CourseIdAndSemesterLecturerCourse_SemesterId(courseId, semesterId);
        Iterable<StudentCourse> studentCourses =
                studentCourseRepository.findByCourseByStudent_CourseIdAndSemesterStudentCourse_SemesterIdAndStatus(courseId, semesterId, "Approved");
        Course course = courseRepository.findByCourseId(courseId);
        model.addAttribute("course", course);
        model.addAttribute("lecturerList", lecturerCourses);
        model.addAttribute("studentList", studentCourses);
        return "admin/courseDetail";
    }

    @GetMapping("/course/detail/{courseId}/{semesterId}/downloadCSV")
    public void downloadCSV(@PathVariable("courseId") int courseId,
                            @PathVariable("semesterId") int semesterId,
                            HttpServletResponse res) throws IOException {
        csvWriter.writeCsv(courseId, semesterId, res);
//        res.setContentType("application/octet-stream");
//        res.setHeader("Content-Disposition", "attachment; filename=\"TSR.csv\"");
//        try {
//            // Write the header line
//            OutputStream o = res.getOutputStream();
//            String header = "ID,ControlNumber\n";
//            o.write(header.getBytes());
//
//            // Write the data lines
////            Vector records = getRecords(); // Custom to my app
////            Iterator i = records.iterator();
////            while (i.hasNext()) {
////                // Custom data object; use your own
////                StandardReportDTO sr = (StandardReportDTO) i.next();
//                StringBuffer line = new StringBuffer();
//                line.append("aaaa");
//                line.append(",");
//                line.append("bbbb");
//                line.append("\n");
//                o.write(line.toString().getBytes());
//                o.flush();
////            }
//
//        } catch (Exception e) {
////          log.error(e);
//        }

    }


    @GetMapping("/course/detail/{id}/addSemester")
    public String addSemester(@PathVariable("id") int id, Model model) {
        LecturerCourse lecturerCourse = new LecturerCourse();
        lecturerCourse.setCourseByLecturer(courseRepository.findByCourseId(id));
        model.addAttribute("lecturerCourse", lecturerCourse);
        return "admin/courseSemesterForm";
    }


    @PostMapping("/course/detail/{id}/addSemester")
    public String addSemester(@Valid LecturerCourse lecturerCourse, Model model, BindingResult result,
                              @PathVariable("id") int id) {
        if (result.hasErrors()) {
            model.addAttribute("id", id);
            return "admin/courseSemesterForm";
        }
        lecturerCourse.setCourseByLecturer(courseRepository.findByCourseId(id));
        lecturerCourseRepository.save(lecturerCourse);
        return "redirect:/admin/course/detail/{id}";
    }

    @GetMapping("/student/{id}}")
    public String studentDetail(@PathVariable("id") int id, Model model) {
        Student student = studentRepository.findByStudentId(id);
        Iterable<StudentCourse> coursesByStudent = studentCourseRepository.findByStudentByCourse_StudentId(id);
        model.addAttribute("student", student);
        model.addAttribute("coursesByStudent", coursesByStudent);
        return "admin/studentDetail";
    }

    @GetMapping("/lecturer/{id}}")
    public String lecturerDetail(@PathVariable("id") int id, Model model) {
        Lecturer lecturer = lecturerRepository.findByLecturerId(id);
        Set<LecturerCourse> coursesByLecturer = lecturerCourseRepository.findByLecturerByCourse_LecturerId(id);
        model.addAttribute("lecturer", lecturer);
        model.addAttribute("coursesByLecturer", coursesByLecturer);
        return "admin/lecturerDetail";
    }


}
