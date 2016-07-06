package javaschool.selenium;

import javaschool.entities.Product;

import java.util.List;
import java.util.Set;

public interface ProductDao extends GenericDao<Product, Long> {
    List<Product> getProducts();

    List<Product> getCollectionProducts(String brand, String collection);

    Set<String> getBrands();

    String getBrand(String collection);

    Set<String> getCollections();

    Set<String> getCollections(String brand);

    Set<Product> getFilteredProducts(String brand, String collection, String price,
                                     String weight, String length, String width,
                                     String color);

    Set<String> getColors();

    List<Product> getPageProducts(int pageNumber, int pageSize);
}