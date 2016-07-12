package javaschool.service;

import javaschool.dao.OrdersDao;
import javaschool.entities.Client;
import javaschool.entities.Orders;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service("OrdersService")
@Transactional
public class OrdersServiceImpl extends GenericServiceImpl<Orders, Long> implements OrdersService {
    private static final org.apache.log4j.Logger logger = Logger.getLogger(OrdersServiceImpl.class);

    private OrdersDao ordersDao;

    @Autowired
    @Qualifier(value = "OrdersDao")
    public void setOrdersDao(OrdersDao ordersDao) {
        this.ordersDao = ordersDao;
    }

    public List<Orders> getOrders() {
        try {
            return ordersDao.getOrders();
        } catch (SQLException e) {
            logger.error("Exception occurred during OrdersService.getOrders() call");
            return null;
        }
    }

    public List<Long> getClientOrders(Client client) {
        try {
            return ordersDao.getClientOrders(client);
        } catch (SQLException e) {
            logger.error("Exception occurred during OrdersService.getClientOrders() call");
            return null;
        }
    }

    public Orders getOrderbyId(Long id) {
        try {
            return ordersDao.get(id);
        } catch (SQLException e) {
            logger.error("Exception occurred during OrdersService.getOrderbyId() call");
            return null;
        }
    }

    public void updateByOrder(Orders orders) {
        try {
            ordersDao.update(orders);
        } catch (SQLException e) {
            logger.error("Exception occurred during OrdersService.updateByOrder() call");
        }
    }

    public Orders addByOrder(Orders orders) {
        try {
            return ordersDao.add(orders);
        } catch (SQLException e) {
            logger.error("Exception occurred during OrdersService.addByOrder() call");
            return null;
        }
    }

    public List<Orders> getPageOrders(int pageNumber, int pageSize) {
        try {
            return ordersDao.getPageOrders(pageNumber, pageSize);
        } catch (SQLException e) {
            logger.error("Exception occurred during OrdersService.getPageOrders() call");
            return null;
        }
    }
}
