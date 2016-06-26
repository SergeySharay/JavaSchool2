/**
 * @author Sergey Sharay
 * @version 1.0
 */
package javaschool.dao;

import javaschool.entities.OrderProduct;
import javaschool.entities.Orders;

import java.util.List;

/**
 * Dao interface for OrderProduct entity.
 */
public interface OrderProductDao extends GenericDao<OrderProduct, Long> {
    /**
     * @param order Orders to find OrderProducts
     * @return a List of OrderProduct by Orders in DB
     */
    List<OrderProduct> getOrderProduct(Orders order);

    /**
     * @return a List of all OrderProduct in DB
     */
    List<OrderProduct> getOrderProducts();
}
