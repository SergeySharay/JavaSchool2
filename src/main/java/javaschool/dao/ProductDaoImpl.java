/**
 * Dao class for Product entities.
 *
 * @author Sergey Sharay
 * @version 1.0
 */
package javaschool.dao;

import com.google.common.base.Strings;
import javaschool.em.EntityManagerAc;
import javaschool.entities.Product;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.*;

public class ProductDaoImpl extends GenericDaoImpl<Product, Long> implements ProductDao {
    /**
     * Class constructor.
     */

    public ProductDaoImpl() {
        super(Product.class);
    }

    /**
     * Get a list of all Products from DB.
     *
     * @return List of Products.
     */
    public List<Product> getProducts() {
        try (EntityManagerAc entityManager = getEntityManager()) {
            entityManager.getTransaction().begin();
            TypedQuery<Product> namedQuery = entityManager.createNamedQuery("Product.getProducts", Product.class);
            entityManager.getTransaction().commit();
            return namedQuery.getResultList();
        }
    }

    /**
     * Get all products for Brand,Collection from DB.
     *
     * @param brand      Brand for searching collections.
     * @param collection Collection for searching products.
     * @return List of Products.
     */
    public List<Product> getProducts(final String brand, final String collection) {
        try (EntityManagerAc entityManager = getEntityManager()) {
            entityManager.getTransaction().begin();
            TypedQuery<Product> namedQuery = entityManager.createNamedQuery("Product.getProductsInCollection", Product.class);
            namedQuery.setParameter("collection", collection);
            namedQuery.setParameter("brand", brand);
            entityManager.getTransaction().commit();
            return namedQuery.getResultList();
        }
    }

    /**
     * Get a set of all Brands from DB.
     *
     * @return Set of Strings.
     */
    public Set<String> getBrands() {
        try (EntityManagerAc entityManager = getEntityManager()) {
            entityManager.getTransaction().begin();
            TypedQuery<String> namedQuery = entityManager.createNamedQuery("Product.getBrands", String.class);
            entityManager.getTransaction().commit();
            return new HashSet<String>(namedQuery.getResultList());
        }
    }

    /**
     * Get a brand by collection from DB.
     *
     * @param collection A collection in a brand.
     * @return Single string with brand.
     */
    public String getBrand(String collection) {
        try (EntityManagerAc entityManager = getEntityManager()) {
            entityManager.getTransaction().begin();
            TypedQuery<String> namedQuery = entityManager.createNamedQuery("Product.getBrand", String.class);
            namedQuery.setParameter("collection", collection);
            entityManager.getTransaction().commit();
            return namedQuery.getSingleResult();
        }
    }

    /**
     * Get all collections from DB.
     *
     * @return HashSet of Strings with collections.
     */
    public Set<String> getCollections() {
        try (EntityManagerAc entityManager = getEntityManager()) {
            entityManager.getTransaction().begin();
            TypedQuery<String> namedQuery = entityManager.createNamedQuery("Product.getAllCollections", String.class);
            entityManager.getTransaction().commit();
            return new HashSet<String>(namedQuery.getResultList());
        }
    }

    /**
     * Get collections for current brand from DB.
     *
     * @param brand A brand for finding collections.
     * @return HashSet of Strings with collections in brand .
     */
    public Set<String> getCollections(final String brand) {
        try (EntityManagerAc entityManager = getEntityManager()) {
            entityManager.getTransaction().begin();
            TypedQuery<String> namedQuery = entityManager.createNamedQuery("Product.getCollections", String.class);
            namedQuery.setParameter("brand", brand);
            entityManager.getTransaction().commit();
            return new HashSet<String>(namedQuery.getResultList());
        }
    }

    /**
     * Get Products from DB by filter
     *
     * @param brand      A brand for finding.
     * @param collection A collection for finding.
     * @param price      A price for finding.
     * @param weight     A weight for finding.
     * @param length     A length for finding.
     * @param width      A width for finding.
     * @param color      A color for finding.
     * @return HashSet of Products after filtering.
     */
    public Set<Product> getFilteredProducts(String brand, String collection, String price,
                                            String weight, String length, String width,
                                            String color) {
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
        try (EntityManagerAc entityManager = getEntityManager()) {
            entityManager.getTransaction().begin();
            Query nativeQuery = entityManager.createNativeQuery(query, Product.class);
            entityManager.getTransaction().commit();
            return new HashSet<Product>(nativeQuery.getResultList());
        }
    }

    private String getSqlPart(String collection, String sqlPart) {
        if (!Strings.isNullOrEmpty(collection)) {
            return sqlPart.concat(collection);
        } else {
            return null;
        }
    }

    /**
     * Get all colors from DB.
     *
     * @return HashSet of Strings with all colors in DB .
     */
    public Set<String> getColors() {
        try (EntityManagerAc entityManager = getEntityManager()) {
            entityManager.getTransaction().begin();
            TypedQuery<String> namedQuery = entityManager.createNamedQuery("Product.getColors", String.class);
            entityManager.getTransaction().commit();
            return new HashSet<String>(namedQuery.getResultList());
        }
    }
}
