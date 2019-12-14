package SpringCA.Controller;

import SpringCA.Repository.AdminUserRepository;
import SpringCA.Repository.LecturerUserRepository;
import SpringCA.Repository.StudentUserRepository;
import SpringCA.Service.UserService;
import SpringCA.entities.AdminUser;
import SpringCA.entities.LecturerUser;
import SpringCA.entities.StudentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    private AdminUserRepository adminUserRepository;
    private StudentUserRepository studentUserRepository;
    private LecturerUserRepository lecturerUserRepository;
    private UserService userService;

    @Autowired
    public HomeController(AdminUserRepository adminUserRepository, StudentUserRepository studentUserRepository,
                          LecturerUserRepository lecturerUserRepository, UserService userService) {
        this.adminUserRepository = adminUserRepository;
        this.studentUserRepository = studentUserRepository;
        this.lecturerUserRepository = lecturerUserRepository;
        this.userService = userService;
    }

    @RequestMapping("/login_{id}")
    public String login1(@RequestParam(required = false) String message, final Model model, @PathVariable String id) {
        if (message != null && !message.isEmpty()) {
            if (message.equals("logout")) {
                model.addAttribute("message", "Logout!");
            }
            if (message.equals("error")) {
                model.addAttribute("message", "Login Failed!");
            }
        }
        model.addAttribute("id", id);
        return "login";
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/admin/admin")
    public String admin(Model model, HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        if(session != null) {
//            if (session.isNew()) {
//                System.out.println("New session is just created");
//            } else {
//                System.out.println("This is old session");
//            }
//        }else{
//            System.out.println("null");
//        }

//        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
//        System.out.println(attr.getRequest().getSession(true));
        AdminUser adminUser = adminUserRepository.findByUsername(userService.getUsername());
        model.addAttribute("adminUser", adminUser);
        return "admin/index";
    }

    @RequestMapping("/lecturer/lecturer")
    public String lecturer(Model model) {
        LecturerUser lecturerUser = lecturerUserRepository.findByUsername(userService.getUsername());
        model.addAttribute("lecturerUser", lecturerUser);
        return "lecturer/index";
    }

    @RequestMapping("/student/student")
    public String user(Model model) {
        StudentUser studentUser = studentUserRepository.findByUsername(userService.getUsername());
        model.addAttribute("studentUser", studentUser);
        return "student/index";
    }

    @RequestMapping("/403")
    public String accessDenied403() {
        return "403";
    }

}
