package javaschool.contollers;

import javaschool.domain.User;
import javaschool.entities.*;
import javaschool.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes(value = "Cart")
public class CartController {

    private ClientService clientService;
    private ProductService productService;
    private ClientAddressService clientAddressService;
    private OrdersService ordersService;
    private OrderProductService orderProductService;

    @Autowired
    @Qualifier(value = "OrderProductService")
    public void setOrderProductService(OrderProductService orderProductService) {
        this.orderProductService = orderProductService;
    }

    @Autowired
    @Qualifier(value = "OrdersService")
    public void setOrdersService(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @Autowired
    @Qualifier(value = "ClientAddressService")
    public void setClientAddressService(ClientAddressService clientAddressService) {
        this.clientAddressService = clientAddressService;
    }

    @Autowired
    @Qualifier(value = "ClientService")
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @Autowired
    @Qualifier(value = "ProductService")
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.GET)
    public ModelAndView addProduct(@ModelAttribute(value = "Cart") Map<Product, Integer> Cart,
                                   @RequestParam(value = "Page", required = false) String page,
                                   @RequestParam(value = "Brand", required = false) String brand,
                                   @RequestParam(value = "Collection", required = false) String collection,
                                   @RequestParam(value = "Product", required = false) Long productId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:" + page);
        modelAndView.addObject("Brand", brand);
        modelAndView.addObject("Collection", collection);
        modelAndView.addObject("Product", productId);
        Product product = productService.findById(productId);

        if (Cart.containsKey(product)) {
            Cart.put(product, Cart.get(product) + 1);
        } else {
            Cart.put(product, 1);
        }

        return modelAndView;
    }

    @ModelAttribute("Cart")
    public Map<Product, Integer> createMap() {
        return new LinkedHashMap<Product, Integer>();
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public ModelAndView ChangeQuantity(@ModelAttribute(value = "Cart") Map<Product, Integer> Cart,
                                       @RequestParam(value = "Quantity", required = false) String quantity,
                                       @RequestParam(value = "ProductId", required = false) Long ProductId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/bucket");
        Product product = productService.findById(ProductId);
        Map<Product, Integer> order = Cart;
        if (quantity.equals("+1")) {
            order.put(product, order.get(product) + 1);
        }
        if (quantity.equals("-1"))
            if (order.get(product) == 1) {
                order.remove(product);
            } else {
                order.put(product, order.get(product) - 1);
            }
        return modelAndView;
    }

    @RequestMapping(value = "/checkout", method = RequestMethod.GET)
    public ModelAndView CheckOut(@RequestParam(value = "sum", required = false) String sum) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cabinetcheckout");
        modelAndView.addObject("sum", sum);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = user.getUsername();
        Client client = clientService.getClient(email);
        ClientAddress clientAddress = clientAddressService.getAddress(client);
        modelAndView.addObject("clientAddress", clientAddress);
        return modelAndView;
    }

    @RequestMapping(value = "/cabinetgetorder", method = RequestMethod.POST)
    public ModelAndView GetOrder(@ModelAttribute(value = "Cart") Map<Product, Integer> Cart,
                                 @RequestParam(value = "Rad1", required = false) String payment,
                                 @RequestParam(value = "Rad2", required = false) String delivery,
                                 @RequestParam(value = "Rad3", required = false) String orderStatus) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = user.getUsername();
        Client client = clientService.getClient(email);
        Orders order = new Orders();
        order.setClient(client);
        order.setPayment(payment);
        order.setDelivery(delivery);
        order.setPaymentStatus("Ожидает оплаты");
        order.setOrderStatus(orderStatus);
        order.setOrderDate(new Date());
        Orders orderFromDb = ordersService.addByOrder(order);

        for (Map.Entry entry : Cart.entrySet()) {
            OrderProduct orderProduct = new OrderProduct();
            orderProduct.setOrderId(orderFromDb);
            orderProduct.setProductId((Product) entry.getKey());
            orderProduct.setQuantity(((Integer) entry.getValue()).longValue());
            orderProductService.addByOrderProduct(orderProduct);
        }
        Map<Product, Integer> orderMap = Cart;
        orderMap.clear();
        return modelAndView;
    }

    @RequestMapping(value = "/cabinetorders", method = RequestMethod.POST)
    public ModelAndView repeatOrder(@ModelAttribute(value = "Cart") Map<Product, Integer> Cart,
                                    @RequestParam(value = "orderId", required = false) Long orderId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("bucket");
        Map<Product, Integer> orderMap = Cart;
        orderMap.clear();
        Orders order = ordersService.getOrderbyId(orderId);
        List<OrderProduct> orderProductList = orderProductService.getOrderProduct(order);
        for (OrderProduct orderProduct : orderProductList) {
            orderMap.put(orderProduct.getProductId(), orderProduct.getQuantity().intValue());
        }
        return modelAndView;
    }
}
