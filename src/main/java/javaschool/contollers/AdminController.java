package javaschool.contollers;

import javaschool.service.ClientService;
import javaschool.service.OrdersService;
import javaschool.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by Sergey on 30.06.2016.
 */
@Controller

public class AdminController {

    DateFormat format = new SimpleDateFormat("dd.MM.yyyy");

    @Autowired
    @Qualifier(value = "ClientService")
    private ClientService clientService;

    @Autowired
    @Qualifier(value = "OrdersService")
    private OrdersService ordersService;

    @Autowired
    @Qualifier(value = "ProductService")
    private ProductService productService;


    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView admin() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin");
        return modelAndView;
    }

    @RequestMapping(value = "/adminclients", method = RequestMethod.GET)
    public ModelAndView clients() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminclients");
        modelAndView.addObject("clientList", clientService.getClients());
        modelAndView.addObject("format", format);
        return modelAndView;
    }

    @RequestMapping(value = "/adminorders", method = RequestMethod.GET)
    public ModelAndView orders() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminorders");
        modelAndView.addObject("ordersList", ordersService.getOrders());
        modelAndView.addObject("format", format);
        return modelAndView;
    }

    @RequestMapping(value = "/adminproducts", method = RequestMethod.GET)
    public ModelAndView products() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminproducts");
        modelAndView.addObject("productList", productService.getProducts());
        modelAndView.addObject("format", format);
        return modelAndView;
    }
}
