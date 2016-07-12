package javaschool.service;

import javaschool.dao.OrderProductDao;
import javaschool.dao.OrdersDao;
import javaschool.entities.Client;
import javaschool.entities.OrderProduct;
import javaschool.entities.Orders;
import javaschool.entities.Product;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.*;

@Service("StatisticService")
@Transactional
public class StatisticServiceImpl implements StatisticService {
    private static final org.apache.log4j.Logger logger = Logger.getLogger(StatisticServiceImpl.class);

    private OrderProductDao orderProductDao;
    private OrdersDao ordersDao;

    @Autowired
    @Qualifier(value = "OrderProductDao")
    public void setOrderProductDao(OrderProductDao orderProductDao) {
        this.orderProductDao = orderProductDao;
    }

    @Autowired
    @Qualifier(value = "OrdersDao")
    public void setOrdersDao(OrdersDao ordersDao) {
        this.ordersDao = ordersDao;
    }

    public Map<Product, Long> findTopTenProducts() {
        List<OrderProduct> orderProductList = null;
        try {
            orderProductList = orderProductDao.getOrderProducts();
        } catch (SQLException e) {
            logger.error("Exception occurred during StatisticService.findTopTenProducts() call");
            return null;
        }
        Map<Product, Long> productLongMap = new LinkedHashMap<Product, Long>();

        for (OrderProduct orderProduct : orderProductList) {
            if (productLongMap.containsKey(orderProduct.getProductId())) {
                productLongMap.put(orderProduct.getProductId(),
                        productLongMap.get(orderProduct.getProductId()) + orderProduct.getQuantity());
            } else {
                productLongMap.put(orderProduct.getProductId(), orderProduct.getQuantity());
            }
        }
        Map<Product, Long> sortedMap = sortMap(productLongMap);
        Map<Product, Long> trimMap = trimMap(sortedMap);

        return trimMap;
    }

    private <K, V> Map<K, Long> trimMap(Map<K, Long> sortedMap) {
        Map<K, Long> trimedMap = new LinkedHashMap<K, Long>();
        int i = 0;
        for (Iterator<Map.Entry<K, Long>> it = sortedMap.entrySet().iterator(); it.hasNext() && i < 10; i++) {
            Map.Entry<K, Long> entry = it.next();
            trimedMap.put(entry.getKey(), entry.getValue());
        }
        return trimedMap;
    }

    private <K, V> Map<K, Long> sortMap(Map<K, Long> longMap) {
        List<Map.Entry<K, Long>> list = new LinkedList<Map.Entry<K, Long>>(longMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, Long>>() {
            public int compare(Map.Entry<K, Long> o1, Map.Entry<K, Long> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        Map<K, Long> sortedMap = new LinkedHashMap<K, Long>();
        for (Iterator<Map.Entry<K, Long>> it = list.iterator(); it.hasNext(); ) {
            Map.Entry<K, Long> entry = it.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

    public Map<Client, Long> findTopTenClients() {
        List<Orders> ordersList = null;
        try {
            ordersList = ordersDao.getOrders();
        } catch (SQLException e) {
            logger.error("Exception occurred during StatisticService.findTopTenClients() call");
            return null;
        }
        Map<Client, Long> ordersLongMap = new LinkedHashMap<Client, Long>();

        for (Orders orders : ordersList) {
            if (ordersLongMap.containsKey(orders.getClient())) {
                ordersLongMap.put(orders.getClient(), (ordersLongMap.get(orders.getClient()) + 1L));
            } else {
                ordersLongMap.put(orders.getClient(), 1L);
            }
        }
        Map<Client, Long> sortedClientMap = sortMap(ordersLongMap);
        Map<Client, Long> trimedClientMap = trimMap(sortedClientMap);
        return trimedClientMap;
    }

    public List<Orders> ordersForAWeeks(Integer weeks) {
        List<Orders> ordersList = null;
        try {
            ordersList = ordersDao.getOrders();
        } catch (SQLException e) {
            logger.error("Exception occurred during StatisticService.ordersForAWeeks() call");
            return null;
        }
        List<Orders> ordersListDate = new LinkedList<Orders>();
        for (Orders orders : ordersList) {
            if (orders.getOrderDate().compareTo(DateUtils.addWeeks(new Date(), -weeks)) > 0) {
                ordersListDate.add(orders);
            }
        }
        return ordersListDate;
    }
}
