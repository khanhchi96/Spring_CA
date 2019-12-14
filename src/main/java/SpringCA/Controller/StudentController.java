package SpringCA.Controller;

import SpringCA.Repository.StudentCourseRepository;
import SpringCA.Repository.StudentRepository;
import SpringCA.Repository.StudentUserRepository;
import SpringCA.Service.StudentService;
import SpringCA.Service.StudentServiceImpl;
import SpringCA.Service.UserService;
import SpringCA.entities.*;
import SpringCA.model.ResetPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private StudentCourseRepository studentCourseRepository;

	@Autowired
	private StudentUserRepository studentUserRepository;

	@Autowired
	private StudentServiceImpl studentServiceImpl;

	@Autowired
	private StudentService studentService;

	@Autowired
	private UserService userService;

	@GetMapping(value = "/profile")
	public String getProfile(Model model){
		StudentUser studentUser = studentUserRepository.findByUsername(userService.getUsername());
		model.addAttribute("studentUser", studentUser);
		model.addAttribute("student", studentUser.getStudentUser());
		return "student/studentProfile";
	}

	@GetMapping(value = "/changePassword/{username}")
	public String changePassword(@PathVariable("username") String username, Model model, ResetPassword resetPassword){
		model.addAttribute("username", username);
		model.addAttribute("security", "student");
		return "resetPassword";
	}

	@PostMapping(value = "/changePassword/{username}")
	public String resetPassword(@PathVariable("username") String username,
								@Valid ResetPassword resetPassword,
								BindingResult result, Model model){
		if(result.hasErrors()){
			model.addAttribute("username", username);
			return "resetPassword";
		}
		userService.resetStudentPassword(username, resetPassword.getPassword());
		return "redirect:/student/profile";
	}


	@GetMapping("/edit/{studentId}")
	public String showEditForm(@PathVariable("studentId") int studentId, Model model) {
		Student student = studentRepository.findById(studentId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + studentId));
		model.addAttribute("student", student);
		return "student/stuInfoForm";
	}

	@RequestMapping(value = "/editSave", path = "/editSave", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "text/html")
	public String updateInfo(@ModelAttribute("student") Student student, BindingResult bindingResult, Model model) {
		Student updateStu = studentServiceImpl.updateStudent(student.getStudentId(), student);
		model.addAttribute("student", updateStu);
		return "redirect:/student/profile";
	}

	@GetMapping("/courseEnrolled/{studentId}")
	public String listEnrolledCourse(@PathVariable("studentId") int studentId, Model model) {
		Iterable<StudentCourse> courseEnrolled = studentCourseRepository.findByStudentByCourse_StudentId(studentId);
		model.addAttribute("courseEnrolled", courseEnrolled);
		return "student/stuCourse";
	}

	@GetMapping("/courseScore/{studentId}")
	public String listCourseScores(@PathVariable("studentId") int studentId, Model model) {
		Student student = studentRepository.findById(studentId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + studentId));
		Iterable<StudentCourse> studentCourses = studentCourseRepository.findByStudentByCourse_StudentId(studentId);
		List<Semester> semesters = new ArrayList<Semester>();
		for (StudentCourse sc : studentCourses) {
			semesters.add(sc.getSemesterStudentCourse());
		}
		semesters = semesters.stream().distinct().collect(Collectors.toList());
		Map<Semester, List<StudentCourse>> semCourseMap = new HashMap<Semester, List<StudentCourse>>();
		for (Semester semester : semesters) {
			Iterable<StudentCourse> studentCoursesBySemester = studentCourseRepository.findByCourseByStudent_CourseIdAndSemesterStudentCourse_SemesterIdAndStatus(
					studentId, semester.getSemesterId(), "Approved"
			);
			semCourseMap.put(semester, (List<StudentCourse>) studentCoursesBySemester);
		}
		model.addAttribute("student", student);
		model.addAttribute("semCourseMap", semCourseMap);
		return "student/courseScore";
	}

}
