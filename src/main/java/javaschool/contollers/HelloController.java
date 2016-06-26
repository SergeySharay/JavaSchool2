package javaschool.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping("/")
    protected ModelAndView Index(Model model) {
        // model.addAttribute("msg", "OMG!");
        return new ModelAndView("index");
    }
    /*  @RequestMapping("/")
      public ModelAndView index(){
          ModelAndView modelAndView = new ModelAndView();
          modelAndView.setViewName("index");
          return modelAndView;
      }*/


    @RequestMapping("/about")
    protected String About(Model model) {
        // model.addAttribute("msg", "OMG!");
        return "about";
    }

    @RequestMapping("/contacts")
    protected String Contacts(Model model) {
        // model.addAttribute("msg", "OMG!");
        return "contacts";
    }

    @RequestMapping("/delivery")
    protected String Delivery(Model model) {
        // model.addAttribute("msg", "OMG!");
        return "delivery";
    }

    @RequestMapping("/pay")
    protected String Pay(Model model) {
        // model.addAttribute("msg", "OMG!");
        return "pay";
    }

}