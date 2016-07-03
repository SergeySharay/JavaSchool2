package javaschool.contollers;

import com.google.common.base.Strings;
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
public class CatalogController {


    private ProductService productService;

    @Autowired
    @Qualifier(value = "ProductService")
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/catalog", method = RequestMethod.GET)
    public ModelAndView catalog(@RequestParam(value = "Brands", required = false) String brand) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("catalog");
        modelAndView.addObject("catalogMenuBrandList", productService.getBrands());
        if (Strings.isNullOrEmpty(brand)) {
            modelAndView.addObject("catalogCollectionList", productService.getCollections());
        } else {
            modelAndView.addObject("catalogCollectionList", productService.getCollections(brand));
            modelAndView.addObject("catalogBrand", brand);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/collection", method = RequestMethod.GET)
    public ModelAndView collection(@RequestParam(value = "Brand", required = false) String brand,
                                   @RequestParam(value = "Collection", required = false) String collection) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("collection");
        if (Strings.isNullOrEmpty(brand)) {
            brand = productService.getBrand(collection);
            modelAndView.addObject("Brand", brand);
            modelAndView.addObject("Collections", productService.getCollections(brand));
            modelAndView.addObject("ProductsInCollection", productService.getCollectionProducts(brand, collection));
        } else {
            modelAndView.addObject("Brand", brand);
            modelAndView.addObject("Collections", productService.getCollections(brand));
            modelAndView.addObject("ProductsInCollection", productService.getCollectionProducts(brand, collection));
        }
        modelAndView.addObject("Collection", collection);
        return modelAndView;
    }

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public ModelAndView product(@RequestParam(value = "Product") Long product,
                                @RequestParam(value = "Brand") String brand,
                                @RequestParam(value = "Collection") String collection) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("product");
        modelAndView.addObject("Brand", brand);
        modelAndView.addObject("Collection", collection);
        modelAndView.addObject("Product", productService.findById(product));
        return modelAndView;
    }

    @RequestMapping(value = "/bucket", method = RequestMethod.GET)
    public ModelAndView bucket(@ModelAttribute(value = "Cart") Map<Product, Integer> Cart) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("bucket");
        return modelAndView;
    }

    @ModelAttribute("Cart")
    public Map<Product, Integer> createMap() {
        return new LinkedHashMap<Product, Integer>();
    }

    @RequestMapping(value = "/filter", method = RequestMethod.GET)
    public ModelAndView filter() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("filter");
        modelAndView.addObject("FilterBrands", productService.getBrands());
        modelAndView.addObject("FilterCollections", productService.getCollections());
        modelAndView.addObject("FilterProducts", productService.getProducts());
        modelAndView.addObject("FilterColors", productService.getColors());

        return modelAndView;
    }
}

