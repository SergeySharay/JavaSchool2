package javaschool.contollers;

import javaschool.dao.ProductDaoImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.Set;

@Controller
public class CatalogController {
    ProductDaoImpl productDao = new ProductDaoImpl();
    Set<String> productSet =  productDao.getBrands();

    @RequestMapping("/catalog")
    public ModelAndView catalog() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("catalog");

        modelAndView.addObject("catalogMenuBrandList", productSet);
        //modelAndView.addObject("catalogCollectionList",productDao.getCollections());

        return modelAndView;
    }
}

