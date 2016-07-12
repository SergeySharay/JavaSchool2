/**
 * Dao class for OrderProduct entities.
 *
 * @author Sergey Sharay
 * @version 1.0
 */
package javaschool.dao;

import javaschool.entities.OrderProduct;
import javaschool.entities.Orders;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.List;

@Repository("OrderProductDao")
public class OrderProductDaoImpl extends GenericDaoImpl<OrderProduct, Long> implements OrderProductDao {
    public OrderProductDaoImpl() {
        super(javaschool.entities.OrderProduct.class);
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<OrderProduct> getOrderProduct(final Orders order) throws SQLException {
        try {
            TypedQuery<OrderProduct> namedQuery = entityManager.createNamedQuery("OrderProduct.getOrderProducts", OrderProduct.class);
            namedQuery.setParameter("order", order);
            return namedQuery.getResultList();
        } catch (Exception ex) {
            throw new SQLException("Exception occurred in OrderProductDao.getOrderProduct()", ex);
        }
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<OrderProduct> getOrderProducts() throws SQLException {
        try {
            TypedQuery<OrderProduct> namedQuery = entityManager.createNamedQuery("OrderProduct.getAllOrderProduct", OrderProduct.class);
            return namedQuery.getResultList();
        } catch (Exception ex) {
            throw new SQLException("Exception occurred in OrderProductDao.getOrderProducts()", ex);
        }
    }
}
