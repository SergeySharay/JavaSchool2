/**
 * @author Sergey Sharay
 * @version 1.0
 */
package javaschool.dao;

import javaschool.entities.Client;
import javaschool.entities.OrderProduct;
import javaschool.entities.Orders;

import java.util.List;
import java.util.Set;

public interface OrdersDao extends GenericDao<Orders, Long> {

    public Set<OrderProduct> getBucket(final Orders orders);

    List<Orders> getOrders();

    List<Long> getClientOrders(Client client);

    List<Orders> getPageOrders(int pageNumber, int pageSize);

}
