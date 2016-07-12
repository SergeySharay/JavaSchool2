/**
 * Dao class for Orders entities.
 *
 * @author Sergey Sharay
 * @version 1.0
 */
package javaschool.dao;

import javaschool.entities.Client;
import javaschool.entities.OrderProduct;
import javaschool.entities.Orders;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository("OrdersDao")
public class OrdersDaoImpl extends GenericDaoImpl<Orders, Long> implements OrdersDao {

    public OrdersDaoImpl() {
        super(javaschool.entities.Orders.class);
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Set<OrderProduct> getBucket(final Orders orders) throws SQLException {
        try {
            TypedQuery<OrderProduct> namedQuery = entityManager.createNamedQuery("Orders.getBucket", OrderProduct.class);
            return new HashSet<OrderProduct>(namedQuery.getResultList());
        } catch (Exception ex) {
            throw new SQLException("Exception occurred in OrdersDao.getBucket()", ex);
        }
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Orders> getOrders() throws SQLException {
        try {
            TypedQuery<Orders> namedQuery = entityManager.createNamedQuery("Orders.getOrders", Orders.class);
            return namedQuery.getResultList();
        } catch (Exception ex) {
            throw new SQLException("Exception occurred in OrdersDao.getOrders()", ex);
        }
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Long> getClientOrders(final Client client) throws SQLException {
        try {
            TypedQuery<Long> namedQuery = entityManager.createNamedQuery("Orders.getClientOrders", Long.class);
            namedQuery.setParameter("client", client);
            return namedQuery.getResultList();
        } catch (Exception ex) {
            throw new SQLException("Exception occurred in OrdersDao.getClientOrders()", ex);
        }
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Orders> getPageOrders(int pageNumber, int pageSize) throws SQLException {
        try {
            TypedQuery<Orders> namedQuery = entityManager.createNamedQuery("Orders.getOrders", Orders.class);
            namedQuery.setFirstResult((pageNumber - 1) * pageSize);
            namedQuery.setMaxResults(pageSize);
            return namedQuery.getResultList();
        } catch (Exception ex) {
            throw new SQLException("Exception occurred in OrdersDao.getPageOrders()", ex);
        }
    }
}
