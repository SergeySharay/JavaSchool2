/**
 * Dao class for Orders entities.
 *
 * @author Sergey Sharay
 * @version 1.0
 */
package javaschool.dao;

import javaschool.em.EntityManagerAc;
import javaschool.entities.Client;
import javaschool.entities.OrderProduct;
import javaschool.entities.Orders;

import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OrdersDaoImpl extends GenericDaoImpl<Orders, Long> implements OrdersDao {
    /**
     * Class constructor
     */
    public OrdersDaoImpl() {
        super(Orders.class);
    }

    /**
     * Get a set of OrderProducts from DB for Orders.
     *
     * @param orders An order for search.
     * @return HashSet of OrderProduct.
     */
    public Set<OrderProduct> getBucket(final Orders orders) {
        try (EntityManagerAc entityManager = getEntityManager()) {
            entityManager.getTransaction().begin();
            TypedQuery<OrderProduct> namedQuery = entityManager.createNamedQuery("Orders.getBucket", OrderProduct.class);
            entityManager.getTransaction().commit();
            return new HashSet<OrderProduct>(namedQuery.getResultList());
        }
    }

    /**
     * Get all Orders from DB.
     *
     * @return List of Orders.
     */
    public List<Orders> getOrders() {
        try (EntityManagerAc entityManager = getEntityManager()) {
            entityManager.getTransaction().begin();
            TypedQuery<Orders> namedQuery = entityManager.createNamedQuery("Orders.getOrders", Orders.class);
            entityManager.getTransaction().commit();
            return namedQuery.getResultList();
        }
    }

    /**
     * Get a list of Orders Id from DB for Client.
     *
     * @param client A client for search all orders..
     * @return List of Orders Id.
     */
    public List<Long> getClientOrders(final Client client) {
        try (EntityManagerAc entityManager = getEntityManager()) {
            entityManager.getTransaction().begin();
            TypedQuery<Long> namedQuery = entityManager.createNamedQuery("Orders.getClientOrders", Long.class);
            namedQuery.setParameter("client", client);
            entityManager.getTransaction().commit();
            return namedQuery.getResultList();
        }
    }
}
