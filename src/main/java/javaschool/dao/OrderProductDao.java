/**
 * @author Sergey Sharay
 * @version 1.0
 */
package javaschool.dao;

import javaschool.entities.OrderProduct;
import javaschool.entities.Orders;

import java.sql.SQLException;
import java.util.List;

public interface OrderProductDao extends GenericDao<OrderProduct, Long> {

    List<OrderProduct> getOrderProduct(Orders order) throws SQLException;

    List<OrderProduct> getOrderProducts() throws SQLException;
}
