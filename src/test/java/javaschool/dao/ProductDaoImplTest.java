package javaschool.dao;

import javaschool.service.ProductService;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class ProductDaoImplTest {

    @Autowired
    @Qualifier(value = "ProductService")
    private ProductService productService;

    @Ignore
    @Test
    public void testGetBrands() throws Exception {
    }
}