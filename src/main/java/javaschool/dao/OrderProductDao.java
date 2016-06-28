/**
 * @author Sergey Sharay
 * @version 1.0
 */
package javaschool.dao;

import javaschool.entities.OrderProduct;
import javaschool.entities.Orders;

import java.util.List;

public interface OrderProductDao extends GenericDao<OrderProduct, Long> {

    List<OrderProduct> getOrderProduct(Orders order);

    List<OrderProduct> getOrderProducts();
}
