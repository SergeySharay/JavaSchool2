/**
 * @author Sergey Sharay
 * @version 1.0
 */
package javaschool.dao;

import javaschool.entities.Client;
import javaschool.entities.Orders;

import java.util.List;

/**
 * Dao interface for Orders entity.
 */
public interface OrdersDao extends GenericDao<Orders, Long> {

    List<Orders> getOrders();

    List<Long> getClientOrders(Client client);
}
