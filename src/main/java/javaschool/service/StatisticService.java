package javaschool.service;


import javaschool.entities.Client;
import javaschool.entities.Orders;
import javaschool.entities.Product;

import java.util.List;
import java.util.Map;

public interface StatisticService {

    Map<Product, Long> findTopTenProducts();

    Map<Client, Long> findTopTenClients();

    List<Orders> ordersForAWeeks(Integer weeks);

}
