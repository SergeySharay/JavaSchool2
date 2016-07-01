package javaschool.service;

import javaschool.dao.OrdersDao;
import javaschool.entities.Client;
import javaschool.entities.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("OrdersService")
@Transactional
public class OrdersServiceImpl extends GenericServiceImpl<Orders, Long> implements OrdersService {

    private OrdersDao ordersDao;

    @Autowired
    @Qualifier(value = "OrdersDao")
    public void setOrdersDao(OrdersDao ordersDao) {
        this.ordersDao = ordersDao;
    }

    public List<Orders> getOrders() {
        return ordersDao.getOrders();
    }

    public List<Long> getClientOrders(Client client) {
        return ordersDao.getClientOrders(client);
    }

    public Orders getOrderbyId(Long id) {
        return ordersDao.get(id);
    }

    public void updateByOrder(Orders orders) {
        ordersDao.update(orders);
    }
}
