package javaschool.service;

import javaschool.dao.OrderProductDao;
import javaschool.entities.OrderProduct;
import javaschool.entities.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("OrderProductService")
@Transactional
public class OrderProductServiceImpl extends GenericServiceImpl<OrderProduct, Long> implements OrderProductService {

    private OrderProductDao orderProductDao;

    @Autowired
    @Qualifier(value = "OrderProductDao")
    public void setOrderProductDao(OrderProductDao orderProductDao) {
        this.orderProductDao = orderProductDao;
    }

    public List<OrderProduct> getOrderProduct(Orders order) {
        return orderProductDao.getOrderProduct(order);
    }

    public List<OrderProduct> getOrderProducts() {
        return orderProductDao.getOrderProducts();
    }

    public OrderProduct addByOrderProduct(OrderProduct orderProduct) {
        return orderProductDao.add(orderProduct);
    }

}
