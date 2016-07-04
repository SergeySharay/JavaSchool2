package javaschool.service;

import javaschool.entities.OrderProduct;
import javaschool.entities.Orders;

import java.util.List;

public interface OrderProductService extends GenericService<OrderProduct, Long> {

    List<OrderProduct> getOrderProduct(Orders order);

    List<OrderProduct> getOrderProducts();

    OrderProduct addByOrderProduct(OrderProduct orderProduct);
}