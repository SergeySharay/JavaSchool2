package javaschool.contollers;

import javaschool.entities.Client;
import javaschool.entities.ClientAddress;
import javaschool.service.ClientAddressService;
import javaschool.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    @Qualifier(value = "ClientService")
    private ClientService clientService;
    @Autowired
    @Qualifier(value = "ClientAddressService")
    private ClientAddressService clientAddressService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("reg");
        return modelAndView;
    }

    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public ModelAndView registrationNewUser(@RequestParam(value = "first_name", required = false) String firstName,
                                            @RequestParam(value = "last_name", required = false) String lastName,
                                            @RequestParam(value = "user_name", required = false) String email,
                                            @RequestParam(value = "pass_word", required = false) String password,
                                            @RequestParam(value = "password_confirmation", required = false) String passconf) {
        ModelAndView modelAndView = new ModelAndView();

        if (clientService.getClient(email) != null) {
            modelAndView.addObject("emailerror", "true");
            modelAndView.setViewName("reg");
            return modelAndView;
        } else if (!password.equals(passconf)) {
            modelAndView.addObject("passerror", "true");
            modelAndView.setViewName("reg");
            return modelAndView;
        } else {
            Client client = new Client(email, firstName, lastName, password);
            Client clientFromDB = clientService.addByClient(client);

            ClientAddress clientAddress = new ClientAddress(clientFromDB);
            clientAddressService.addByClientAddress(clientAddress);

            modelAndView.setViewName("login");
            return modelAndView;
        }
    }
}
