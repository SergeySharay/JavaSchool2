package javaschool.service;


import javaschool.entities.Client;
import javaschool.entities.Orders;

import java.util.List;

public interface OrdersService extends GenericService<Orders, Long> {

    List<Orders> getOrders();

    List<Long> getClientOrders(Client client);

    Orders getOrderbyId(Long id);

    void updateByOrder(Orders orders);
}
