/**
 * Dao class for Product entities.
 *
 * @author Sergey Sharay
 * @version 1.0
 */
package javaschool.dao;

import com.google.common.base.Strings;
import javaschool.entities.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository("ProductDao")
public class ProductDaoImpl extends GenericDaoImpl<Product, Long> implements ProductDao {

    public ProductDaoImpl() {
        super(javaschool.entities.Product.class);
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Product> getProducts() throws SQLException {
        try {
            TypedQuery<Product> namedQuery = entityManager.createNamedQuery("Product.getProducts", Product.class);
            return namedQuery.getResultList();
        } catch (Exception ex) {
            throw new SQLException("Exception occurred in ProductDao.getProducts()", ex);
        }
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Product> getCollectionProducts(final String brand, final String collection) throws SQLException {
        try {
            TypedQuery<Product> namedQuery = entityManager.createNamedQuery("Product.getProductsInCollection", Product.class);
            namedQuery.setParameter("collection", collection);
            namedQuery.setParameter("brand", brand);
            return namedQuery.getResultList();
        } catch (Exception ex) {
            throw new SQLException("Exception occurred in ProductDao.getCollectionProducts()", ex);
        }
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Set<String> getBrands() throws SQLException {
        try {
            TypedQuery<String> namedQuery = entityManager.createNamedQuery("Product.getBrands", String.class);
            return new HashSet<String>(namedQuery.getResultList());
        } catch (Exception ex) {
            throw new SQLException("Exception occurred in ProductDao.getBrands()", ex);
        }
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public String getBrand(String collection) throws SQLException {
        try {
            TypedQuery<String> namedQuery = entityManager.createNamedQuery("Product.getBrand", String.class);
            namedQuery.setParameter("collection", collection);
            return namedQuery.getSingleResult();
        } catch (Exception ex) {
            throw new SQLException("Exception occurred in ProductDao.getBrand()", ex);
        }
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Set<String> getCollections() throws SQLException {
        try {
            TypedQuery<String> namedQuery = entityManager.createNamedQuery("Product.getAllCollections", String.class);
            return new HashSet<String>(namedQuery.getResultList());
        } catch (Exception ex) {
            throw new SQLException("Exception occurred in ProductDao.getCollections()", ex);
        }
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Set<String> getCollections(final String brand) throws SQLException {
        try {
            TypedQuery<String> namedQuery = entityManager.createNamedQuery("Product.getCollections", String.class);
            namedQuery.setParameter("brand", brand);
            return new HashSet<String>(namedQuery.getResultList());
        } catch (Exception ex) {
            throw new SQLException("Exception occurred in ProductDao.getCollections()", ex);
        }
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Set<Product> getFilteredProducts(String brand, String collection, String price,
                                            String weight, String length, String width,
                                            String color) throws SQLException {
        String query = "SELECT * FROM product";
        List<String> toBeAppended = new ArrayList<String>();
        toBeAppended.add(getSqlPart(brand, "product_brand = "));
        toBeAppended.add(getSqlPart(color, "product_color = "));
        toBeAppended.add(getSqlPart(collection, "product_collection = "));
        toBeAppended.add(getSqlPart(price, "product_price BETWEEN "));
        toBeAppended.add(getSqlPart(weight, "product_weight BETWEEN "));
        toBeAppended.add(getSqlPart(width, "product_width BETWEEN "));
        toBeAppended.add(getSqlPart(length, "product_length BETWEEN "));
        boolean flag = false;
        for (String s : toBeAppended) {
            if (s != null) {
                if (!flag) {
                    query += " WHERE ";
                } else {
                    query += " AND ";
                }
                query += s;
                flag = true;
            }
        }
        try {
            Query nativeQuery = entityManager.createNativeQuery(query, Product.class);
            return new HashSet<Product>(nativeQuery.getResultList());
        } catch (Exception ex) {
            throw new SQLException("Exception occurred in ProductDao.getFilteredProducts()", ex);
        }
    }

    private String getSqlPart(String collection, String sqlPart) {
        if (!Strings.isNullOrEmpty(collection)) {
            return sqlPart.concat(collection);
        } else {
            return null;
        }
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Set<String> getColors() throws SQLException {
        try {
            TypedQuery<String> namedQuery = entityManager.createNamedQuery("Product.getColors", String.class);
            return new HashSet<String>(namedQuery.getResultList());
        } catch (Exception ex) {
            throw new SQLException("Exception occurred in ProductDao.getColors()", ex);
        }
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Product> getPageProducts(int pageNumber, int pageSize) throws SQLException {
        try {
            TypedQuery<Product> namedQuery = entityManager.createNamedQuery("Product.getProducts", Product.class);
            namedQuery.setFirstResult((pageNumber - 1) * pageSize);
            namedQuery.setMaxResults(pageSize);
            return namedQuery.getResultList();
        } catch (Exception ex) {
            throw new SQLException("Exception occurred in ProductDao.getPageProducts()", ex);
        }
    }
}
