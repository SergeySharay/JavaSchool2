package javaschool.contollers;

import javaschool.entities.Orders;
import javaschool.entities.Product;
import javaschool.service.ClientService;
import javaschool.service.OrdersService;
import javaschool.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

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

    @RequestMapping(value = "/adminclients", method = RequestMethod.POST)
    public ModelAndView clientsChange() {
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

    @RequestMapping(value = "/adminproductpage", method = RequestMethod.GET)
    public ModelAndView productPage(@RequestParam(value = "productId", required = false) Long productId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminproductpage");
        modelAndView.addObject("productPage", productService.findById(productId));
        return modelAndView;
    }

    @RequestMapping(value = "/adminproductpage", method = RequestMethod.POST)
    public ModelAndView productPageSave(@RequestParam(value = "productId", required = false) Long productId,
                                        @RequestParam(value = "brand", required = false) String brand,
                                        @RequestParam(value = "collection", required = false) String collection,
                                        @RequestParam(value = "name", required = false) String name,
                                        @RequestParam(value = "price", required = false) String price,
                                        @RequestParam(value = "length", required = false) String length,
                                        @RequestParam(value = "width", required = false) String width,
                                        @RequestParam(value = "weight", required = false) String weight,
                                        @RequestParam(value = "color", required = false) String color,
                                        @RequestParam(value = "quantity", required = false) String quantity,
                                        @RequestParam(value = "picture", required = false) String picture) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminproductpage");
        Product product = productService.findById(productId);

        if (!brand.equals("")) {
            product.setBrand(brand);
        }
        if (!collection.equals("")) {
            product.setCollection(collection);
        }
        if (!name.equals("")) {
            product.setName(name);
        }

        if (!price.equals("")) {
            product.setPrice(Long.parseLong(price));
        }
        if (!length.equals("")) {
            product.setLength(Long.parseLong(length));
        }
        if (!width.equals("")) {
            product.setWidth(Long.parseLong(width));
        }
        if (!weight.equals("")) {
            product.setWeight(Long.parseLong(weight));
        }
        if (!quantity.equals("")) {
            product.setQuantity(Long.parseLong(quantity));
        }
        if (!color.equals("")) {
            product.setColor(color);
        }
        if (!picture.equals("")) {
            product.setPicture(picture);
        }
        productService.update(product);
        modelAndView.addObject("productPage", product);
        return modelAndView;
    }


    @RequestMapping(value = "/adminproductadd", method = RequestMethod.GET)
    public ModelAndView productPageAdd() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminproductadd");
        return modelAndView;
    }

    @RequestMapping(value = "/adminstatistic", method = RequestMethod.GET)
    public ModelAndView statistic() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminstatistic");
        return modelAndView;
    }

    @RequestMapping(value = "/adminproductadd", method = RequestMethod.POST)
    public ModelAndView productPageAdd(@RequestParam(value = "brand", required = false) String brand,
                                       @RequestParam(value = "collection", required = false) String collection,
                                       @RequestParam(value = "name", required = false) String name,
                                       @RequestParam(value = "price", required = false) String price,
                                       @RequestParam(value = "length", required = false) String length,
                                       @RequestParam(value = "width", required = false) String width,
                                       @RequestParam(value = "weight", required = false) String weight,
                                       @RequestParam(value = "color", required = false) String color,
                                       @RequestParam(value = "quantity", required = false) String quantity
    ) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminproductpage");
        Product product = new Product();

        product.setBrand(brand);
        product.setCollection(collection);
        product.setName(name);
        product.setPrice(Long.parseLong(price));
        product.setLength(Long.parseLong(length));
        product.setWidth(Long.parseLong(width));
        product.setWeight(Long.parseLong(weight));
        product.setQuantity(Long.parseLong(quantity));
        product.setColor(color);
        product.setPicture(null);

        Product getProduct = productService.addNewProduct(product);

        modelAndView.addObject("productPage", getProduct);
        return modelAndView;
    }


    @RequestMapping(value = "/adminorderpage", method = RequestMethod.GET)
    public ModelAndView orderPage(@RequestParam(value = "orderId", required = false) Long orderId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminorderpage");
        modelAndView.addObject("orderPage", ordersService.getOrderbyId(orderId));
        modelAndView.addObject("format", format);
        return modelAndView;
    }

    @RequestMapping(value = "/adminorderpage", method = RequestMethod.POST)
    public ModelAndView orderPageSave(@RequestParam(value = "orderId", required = false) Long orderId,
                                      @RequestParam(value = "payment", required = false) String payment,
                                      @RequestParam(value = "delivery", required = false) String delivery,
                                      @RequestParam(value = "paymentstatus", required = false) String paymentstatus,
                                      @RequestParam(value = "orderstatus", required = false) String orderstatus) {


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminorderpage");

        Orders order = ordersService.getOrderbyId(orderId);

        if (!payment.equals("")) {
            order.setPayment(payment);
        }
        if (!delivery.equals("")) {
            order.setDelivery(delivery);
        }
        if (!paymentstatus.equals("")) {
            order.setPaymentStatus(paymentstatus);
        }
        if (!orderstatus.equals("")) {
            order.setOrderStatus(orderstatus);
        }

        ordersService.updateByOrder(order);
        modelAndView.addObject("orderPage", order);
        modelAndView.addObject("format", format);
        return modelAndView;
    }
}
