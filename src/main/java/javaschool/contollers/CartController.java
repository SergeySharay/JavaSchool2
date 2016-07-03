package javaschool.contollers;

import javaschool.entities.Product;
import javaschool.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@SessionAttributes(value = "Cart")
public class CartController {
    private ProductService productService;

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

}
