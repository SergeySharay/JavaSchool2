package javaschool.contollers;

import javaschool.domain.User;
import javaschool.entities.Client;
import javaschool.entities.ClientAddress;
import javaschool.service.ClientAddressService;
import javaschool.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller
public class CabinetController {

    DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
    DateFormat getFormat = new SimpleDateFormat("yyyy-MM-dd");

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

    @RequestMapping(value = "/cabinetpayment", method = RequestMethod.GET)
    public ModelAndView payment(@RequestParam(value = "summer", required = false) String summer) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cabinetpayment");
        modelAndView.addObject("summer", summer);
        return modelAndView;
    }

    @RequestMapping(value = "/cabinetpersonal", method = RequestMethod.POST)
    public ModelAndView personalSave(@RequestParam(value = "firstName", required = false) String firstName,
                                     @RequestParam(value = "lastName", required = false) String lastName,
                                     @RequestParam(value = "email", required = false) String newEmail,
                                     @RequestParam(value = "pass", required = false) String pass,
                                     @RequestParam(value = "date", required = false) String date) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cabinetpersonal");
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = user.getUsername();
        Client client = clientService.getClient(email);
        if (clientService.getClient(newEmail) == null) {
            if (!firstName.equals("")) {
                client.setName(firstName);
            }
            if (!lastName.equals("")) {
                client.setSurname(lastName);
            }
            if (!newEmail.equals("")) {
                client.setEmail(newEmail);
            }
            if (!pass.equals("")) {
                client.setPassword(pass);
            }
            if (!date.equals("")) {
                try {
                    client.setBirthday(getFormat.parse(date));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            modelAndView.addObject("emailError", "");
            clientService.updateByClient(client);
        } else {
            modelAndView.addObject("emailError", "true");
        }

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

    @RequestMapping(value = "/cabinetaddress", method = RequestMethod.POST)
    public ModelAndView addressSave(@RequestParam(value = "country", required = false) String country,
                                    @RequestParam(value = "city", required = false) String city,
                                    @RequestParam(value = "street", required = false) String street,
                                    @RequestParam(value = "house", required = false) String house,
                                    @RequestParam(value = "flat", required = false) String flat,
                                    @RequestParam(value = "zipcode", required = false) String zipcode) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cabinetaddress");
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = user.getUsername();
        Client client = clientService.getClient(email);
        ClientAddress clientAddress = clientAddressService.getAddress(client);

        if (!country.equals("")) {
            clientAddress.setCountry(country);
        }
        if (!city.equals("")) {
            clientAddress.setCity(city);
        }
        if (!street.equals("")) {
            clientAddress.setStreet(street);
        }
        if (!house.equals("")) {
            clientAddress.setHouse(house);
        }
        if (!flat.equals("")) {
            clientAddress.setFlat(flat);
        }
        if (!zipcode.equals("")) {
            clientAddress.setZipcode(Long.parseLong(zipcode));
        }
        clientAddressService.updateByClientAddress(clientAddress);

        modelAndView.addObject("format", format);
        modelAndView.addObject("clientAdress", clientAddress);
        return modelAndView;
    }

    @RequestMapping(value = "/cabinetorders", method = RequestMethod.GET)
    public ModelAndView orders() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cabinetorders");
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = user.getUsername();
        Client client = clientService.getClient(email);
        modelAndView.addObject("OrdersSet", clientService.getOrders(client));
        modelAndView.addObject("format", format);
        return modelAndView;
    }

}
