package SpringCA.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

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
    public String admin() {
        return "admin/index";
    }

    @RequestMapping("/lecturer/lecturer")
    public String lecturer() {
        return "lecturer";
    }

    @RequestMapping("/student/student")
    public String user() {
        return "student";
    }

    @RequestMapping("/403")
    public String accessDenied403() {
        return "403";
    }

}
