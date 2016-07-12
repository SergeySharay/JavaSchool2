package javaschool.service;

import javaschool.dao.OrderProductDao;
import javaschool.entities.OrderProduct;
import javaschool.entities.Orders;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service("OrderProductService")
@Transactional
public class OrderProductServiceImpl extends GenericServiceImpl<OrderProduct, Long> implements OrderProductService {
    private static final org.apache.log4j.Logger logger = Logger.getLogger(OrderProductServiceImpl.class);

    private OrderProductDao orderProductDao;

    @Autowired
    @Qualifier(value = "OrderProductDao")
    public void setOrderProductDao(OrderProductDao orderProductDao) {
        this.orderProductDao = orderProductDao;
    }

    public List<OrderProduct> getOrderProduct(Orders order) {
        try {
            return orderProductDao.getOrderProduct(order);
        } catch (SQLException e) {
            logger.error("Exception occurred during OrderProductService.getOrderProduct() call");
            return null;
        }
    }

    public List<OrderProduct> getOrderProducts() {
        try {
            return orderProductDao.getOrderProducts();
        } catch (SQLException e) {
            logger.error("Exception occurred during OrderProductService.getOrderProducts() call");
            return null;
        }
    }

    public OrderProduct addByOrderProduct(OrderProduct orderProduct) {
        try {
            return orderProductDao.add(orderProduct);
        } catch (SQLException e) {
            logger.error("Exception occurred during OrderProductService.addByOrderProduct() call");
            return null;
        }
    }

}
