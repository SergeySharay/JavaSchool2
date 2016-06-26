/**
 * Dao class for OrderProduct entities.
 *
 * @author Sergey Sharay
 * @version 1.0
 */
package javaschool.dao;

import javaschool.em.EntityManagerAc;
import javaschool.entities.OrderProduct;
import javaschool.entities.Orders;

import javax.persistence.TypedQuery;
import java.util.List;

public class OrderProductDaoImpl extends GenericDaoImpl<OrderProduct, Long> implements OrderProductDao {
    /**
     * Class constructor.
     */
    public OrderProductDaoImpl() {
        super(OrderProduct.class);
    }

    /**
     * Get a list of OrderProducts from DB for Orders.
     *
     * @param order An order for search.
     * @return List of OrderProduct.
     */
    public List<OrderProduct> getOrderProduct(final Orders order) {
        try (EntityManagerAc entityManager = getEntityManager()) {
            entityManager.getTransaction().begin();
            TypedQuery<OrderProduct> namedQuery = entityManager.createNamedQuery("OrderProduct.getOrderProducts", OrderProduct.class);
            namedQuery.setParameter("order", order);
            entityManager.getTransaction().commit();
            return namedQuery.getResultList();
        }
    }

    /**
     * Get a list of all OrderProducts from DB.
     *
     * @return List of all OrderProducts.
     */
    public List<OrderProduct> getOrderProducts() {
        try (EntityManagerAc entityManager = getEntityManager()) {
            entityManager.getTransaction().begin();
            TypedQuery<OrderProduct> namedQuery = entityManager.createNamedQuery("OrderProduct.getAllOrderProduct", OrderProduct.class);
            entityManager.getTransaction().commit();
            return namedQuery.getResultList();
        }
    }
}
