package javaschool.contollers;

import com.google.common.base.Strings;
import javaschool.entities.Product;
import javaschool.service.ProductService;
import org.apache.log4j.Logger;
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
    private static final Logger logger = Logger.getLogger(CatalogController.class);
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

    @RequestMapping(value = "/filter", method = RequestMethod.POST)
    public ModelAndView doFilter(@RequestParam(value = "brand", required = false) String brand,
                                 @RequestParam(value = "col", required = false) String collection,
                                 @RequestParam(value = "price", required = false) String price,
                                 @RequestParam(value = "weight", required = false) String weight,
                                 @RequestParam(value = "length", required = false) String length,
                                 @RequestParam(value = "width", required = false) String width,
                                 @RequestParam(value = "color", required = false) String color) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("filter");
        modelAndView.addObject("FilterBrands", productService.getBrands());
        modelAndView.addObject("FilterCollections", productService.getCollections());
        modelAndView.addObject("FilterColors", productService.getColors());

        if (!brand.equals("")) {
            brand = "'" + brand + "'";
        } else {
            brand = null;
        }

        if (!collection.equals("")) {
            collection = "'" + collection + "'";
        } else {
            collection = null;
        }
        if (!price.equals("")) {
            if (price.equals("1")) {
                price = "0 AND 500";
            } else if (price.equals("2")) {
                price = "500 AND 1500";
            } else if (price.equals("3")) {
                price = "1500 AND 100000";
            } else price = null;
        } else {
            price = null;
        }

        if (!weight.equals("")) {
            if (weight.equals("1")) {
                weight = "0 AND 5";
            } else if ((weight.equals("2"))) {
                weight = "5 AND 10";
            } else if ((weight.equals("3"))) {
                weight = "10 AND 15";
            } else if ((weight.equals("4"))) {
                weight = "15 AND 100";
            } else weight = null;
        } else {
            weight = null;
        }

        if (!length.equals("")) {
            if (length.equals("1")) {
                length = "0 AND 20";
            } else if (length.equals("2")) {
                length = "20 AND 30";
            } else if (length.equals("3")) {
                length = "30 AND 40";
            } else if (length.equals("4")) {
                length = "40 AND 200";
            } else length = null;
        } else {
            length = null;
        }
        if (!color.equals("")) {
            color = "'" + color + "'";
        } else {
            color = null;
        }
        if (!width.equals("")) {
            if (width.equals("1")) {
                width = "0 AND 10";
            } else if (width.equals("2")) {
                width = "10 AND 20";
            } else if (width.equals("3")) {
                width = "20 AND 30";
            } else if (width.equals("4")) {
                width = "30 AND 100";
            } else width = null;
        } else {
            width = null;
        }
        modelAndView.addObject("FilterProducts", productService.getFilteredProducts(brand, collection, price, weight, length, width, color));
        return modelAndView;
    }
}

