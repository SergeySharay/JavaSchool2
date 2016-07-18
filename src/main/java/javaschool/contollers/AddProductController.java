package javaschool.contollers;

import javaschool.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller("AddProductController")
public class AddProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/addproducts", method = RequestMethod.POST)
    public ModelAndView getFile(@RequestParam(value = "file", required = false) final MultipartFile file) {
        ModelAndView modelAndView = new ModelAndView();
        productService.addProducts(file);
        modelAndView.setViewName("redirect:adminproducts");
        return modelAndView;
    }

}
