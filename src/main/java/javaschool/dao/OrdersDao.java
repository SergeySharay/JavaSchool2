/**
 * @author Sergey Sharay
 * @version 1.0
 */
package javaschool.dao;

import javaschool.entities.Client;
import javaschool.entities.OrderProduct;
import javaschool.entities.Orders;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface OrdersDao extends GenericDao<Orders, Long> {

    public Set<OrderProduct> getBucket(final Orders orders) throws SQLException;

    List<Orders> getOrders() throws SQLException;

    List<Long> getClientOrders(Client client) throws SQLException;

    List<Orders> getPageOrders(int pageNumber, int pageSize) throws SQLException;

}
