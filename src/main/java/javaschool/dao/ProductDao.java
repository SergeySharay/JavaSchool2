package javaschool.dao;

import javaschool.entities.Product;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface ProductDao extends GenericDao<Product, Long> {
    List<Product> getProducts() throws SQLException;

    List<Product> getCollectionProducts(String brand, String collection) throws SQLException;

    Set<String> getBrands() throws SQLException;

    String getBrand(String collection) throws SQLException;

    Set<String> getCollections() throws SQLException;

    Set<String> getCollections(String brand) throws SQLException;

    Set<Product> getFilteredProducts(String brand, String collection, String price,
                                     String weight, String length, String width,
                                     String color) throws SQLException;

    Set<String> getColors() throws SQLException;

    List<Product> getPageProducts(int pageNumber, int pageSize) throws SQLException;
}