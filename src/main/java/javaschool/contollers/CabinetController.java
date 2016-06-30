package javaschool.contollers;

import javaschool.domain.User;
import javaschool.entities.Client;
import javaschool.service.ClientAddressService;
import javaschool.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Controller
public class CabinetController {

    DateFormat format = new SimpleDateFormat("dd.MM.yyyy");

    @Autowired
    @Qualifier(value = "ClientService")
    private ClientService clientService;

    @Autowired
    @Qualifier(value = "ClientAddressService")
    private ClientAddressService clientAddressService;

    @RequestMapping(value = "/cabinet", method = RequestMethod.GET)
    public ModelAndView cabinet() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cabinet");
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = user.getUsername();
        Client client = clientService.getClient(email);
        modelAndView.addObject("format", format);
        modelAndView.addObject("User", client);
        modelAndView.addObject("clientAdress", clientAddressService.getAddress(client));
        return modelAndView;
    }

    @RequestMapping(value = "/cabinetpersonal", method = RequestMethod.GET)
    public ModelAndView personal() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cabinetpersonal");
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = user.getUsername();
        Client client = clientService.getClient(email);
        modelAndView.addObject("format", format);
        modelAndView.addObject("User", client);
        return modelAndView;
    }

    @RequestMapping(value = "/cabinetaddress", method = RequestMethod.GET)
    public ModelAndView address() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cabinetaddress");
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = user.getUsername();
        Client client = clientService.getClient(email);
        modelAndView.addObject("format", format);
        modelAndView.addObject("clientAdress", clientAddressService.getAddress(client));
        return modelAndView;
    }

    @RequestMapping(value = "/cabinetorders", method = RequestMethod.GET)
    public ModelAndView orders() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cabinetorders");
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = user.getUsername();
        Client client = clientService.getClient(email);
        modelAndView.addObject("format", format);
        modelAndView.addObject("OrdersSet", clientService.getOrders(client));
        return modelAndView;
    }
}
