package javaschool.service;

import javaschool.dao.ProductDao;
import javaschool.entities.Product;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

@Service("ProductService")
@Transactional
public class ProductServiceImpl extends GenericServiceImpl<Product, Long> implements ProductService {
    private static final org.apache.log4j.Logger logger = Logger.getLogger(ProductServiceImpl.class);

    private ProductDao productDao;

    @Autowired
    @Qualifier(value = "ProductDao")
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Product> getProducts() {
        try {
            return productDao.getProducts();
        } catch (SQLException e) {
            logger.error("Exception occurred during ProductService.getProducts() call");
            return null;
        }
    }

    public List<Product> getCollectionProducts(String brand, String collection) {
        try {
            return productDao.getCollectionProducts(brand, collection);
        } catch (SQLException e) {
            logger.error("Exception occurred during ProductService.getCollectionProducts() call");
            return null;
        }
    }

    public Set<String> getBrands() {
        try {
            return productDao.getBrands();
        } catch (SQLException e) {
            logger.error("Exception occurred during ProductService.getBrands() call");
            return null;
        }
    }

    public String getBrand(String collection) {
        try {
            return productDao.getBrand(collection);
        } catch (SQLException e) {
            logger.error("Exception occurred during ProductService.getBrand() call");
            return null;
        }
    }

    public Set<String> getCollections() {
        try {
            return productDao.getCollections();
        } catch (SQLException e) {
            logger.error("Exception occurred during ProductService.getCollections() call");
            return null;
        }
    }

    public Set<String> getCollections(String brand) {
        try {
            return productDao.getCollections(brand);
        } catch (SQLException e) {
            logger.error("Exception occurred during ProductService.getCollections() call");
            return null;
        }
    }

    public Set<Product> getFilteredProducts(String brand, String collection, String price, String weight, String length, String width, String color) {
        try {
            return productDao.getFilteredProducts(brand, collection, price, weight, length, width, color);
        } catch (SQLException e) {
            logger.error("Exception occurred during ProductService.getFilteredProducts() call");
            return null;
        }
    }

    public Set<String> getColors() {
        try {
            return productDao.getColors();
        } catch (SQLException e) {
            logger.error("Exception occurred during ProductService.getColors() call");
            return null;
        }
    }

    public Product findById(Long id) {
        try {
            return productDao.get(id);
        } catch (SQLException e) {
            logger.error("Exception occurred during ProductService.findById() call");
            return null;
        }
    }

    public Product addNewProduct(Product product) {
        try {
            return productDao.add(product);
        } catch (SQLException e) {
            logger.error("Exception occurred during ProductService.addNewProduct() call");
            return null;
        }
    }

    public List<Product> getPageProducts(int pageNumber, int pageSize) {
        try {
            return productDao.getPageProducts(pageNumber, pageSize);
        } catch (SQLException e) {
            logger.error("Exception occurred during ProductService.getPageProducts() call");
            return null;
        }
    }

    public Void addProducts(MultipartFile file) {
        try {
            InputStream inputStream = file.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            String csvProduct = null;

            while ((csvProduct = bufferedReader.readLine()) != null) {
                Product product = construct(csvProduct);
                productDao.add(product);
            }
        } catch (SQLException ex) {
            logger.error("Exception occurred during ProductService.addProducts() call");
        } catch (UnsupportedEncodingException ex) {
            logger.error("Exception occurred during ProductService.addProducts() call", ex);
        } catch (IOException ex) {
            logger.error("Exception occurred during ProductService.addProducts() call", ex);
        }
        return null;
    }

    private Product construct(String s) {
        String[] split = s.split(",");
        Product product = new Product();
        product.setCategory(split[0]);
        product.setBrand(split[1]);
        product.setCollection(split[2]);
        product.setName(split[3]);
        product.setPrice(Long.parseLong(split[4]));
        product.setLength(Long.parseLong(split[5]));
        product.setWidth(Long.valueOf(split[6]));
        product.setWeight(Long.valueOf(split[7]));
        product.setQuantity(Long.valueOf(split[8]));
        product.setColor(split[9]);
        return product;
    }

}
