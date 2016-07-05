package javaschool.service;

import javaschool.dao.ProductDao;
import javaschool.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service("ProductService")
@Transactional
public class ProductServiceImpl extends GenericServiceImpl<Product, Long> implements ProductService {

    private ProductDao productDao;

    @Autowired
    @Qualifier(value = "ProductDao")
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Product> getProducts() {
        return productDao.getProducts();
    }

    public List<Product> getCollectionProducts(String brand, String collection) {
        return productDao.getCollectionProducts(brand, collection);
    }

    public Set<String> getBrands() {
        return productDao.getBrands();
    }

    public String getBrand(String collection) {
        return productDao.getBrand(collection);
    }

    public Set<String> getCollections() {
        return productDao.getCollections();
    }

    public Set<String> getCollections(String brand) {
        return productDao.getCollections(brand);
    }

    public Set<Product> getFilteredProducts(String brand, String collection, String price, String weight, String length, String width, String color) {
        return productDao.getFilteredProducts(brand, collection, price, weight, length, width, color);
    }

    public Set<String> getColors() {
        return productDao.getColors();
    }

    public Product findById(Long id) {
        return productDao.get(id);
    }

    public Product addNewProduct(Product product) {
        return productDao.add(product);
    }

    public List<Product> getPageProducts(int pageNumber, int pageSize) {
        return productDao.getPageProducts(pageNumber, pageSize);
    }
}
