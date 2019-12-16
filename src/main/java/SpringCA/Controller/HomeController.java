package SpringCA.Controller;

import SpringCA.Repository.AdminUserRepository;
import SpringCA.Repository.LecturerUserRepository;
import SpringCA.Repository.StudentUserRepository;
import SpringCA.Service.UserServiceImpl;
import SpringCA.entities.AdminUser;
import SpringCA.entities.LecturerUser;
import SpringCA.entities.StudentUser;
import SpringCA.model.ResetPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class HomeController {

    private AdminUserRepository adminUserRepository;
    private StudentUserRepository studentUserRepository;
    private LecturerUserRepository lecturerUserRepository;
    private UserServiceImpl userService;

    @Autowired
    public HomeController(AdminUserRepository adminUserRepository, StudentUserRepository studentUserRepository,
                          LecturerUserRepository lecturerUserRepository, UserServiceImpl userService) {
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
        AdminUser adminUser = adminUserRepository.findByUsername(userService.getUsername());
        model.addAttribute("adminUser", adminUser);
        return "redirect:/admin/student/list";
    }

    @RequestMapping("/lecturer/lecturer")
    public String lecturer(Model model) {
        LecturerUser lecturerUser = lecturerUserRepository.findByUsername(userService.getUsername());
        model.addAttribute("lecturerUser", lecturerUser);
        return "redirect:/admin/lecturer/list";
    }

    @RequestMapping("/student/student")
    public String user(Model model) {
        StudentUser studentUser = studentUserRepository.findByUsername(userService.getUsername());
        model.addAttribute("studentUser", studentUser);
        return "redirect:/admin/student/list";
    }

    @RequestMapping("/403")
    public String accessDenied403() {
        return "403";
    }

    @GetMapping(value = "/{security}/changePassword/{username}")
    public String changePassword(@PathVariable("username") String username, Model model,
                                 @PathVariable("security") String security, ResetPassword resetPassword){
        model.addAttribute("username", username);
        model.addAttribute("security", security);
        return "resetPassword";
    }

    @PostMapping(value = "/{security}/changePassword/{username}")
    public String resetPassword(@PathVariable("username") String username, @PathVariable("security") String security,
                                @Valid ResetPassword resetPassword,
                                BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("username", username);
            return "resetPassword";
        }
        userService.resetAdminPassword(username, resetPassword.getPassword());
        return "redirect:/" + security + "/profile";
    }

}
