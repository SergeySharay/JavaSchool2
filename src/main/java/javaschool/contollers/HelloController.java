package javaschool.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping("/")
    protected ModelAndView index(Model model) {
        return new ModelAndView("index");
    }

    @RequestMapping("/about")
    protected String about(Model model) {
        return "about";
    }

    @RequestMapping("/contacts")
    protected String contacts(Model model) {
        return "contacts";
    }

    @RequestMapping("/delivery")
    protected String delivery(Model model) {
        return "delivery";
    }

    @RequestMapping("/pay")
    protected String pay(Model model) {
        return "pay";
    }

}