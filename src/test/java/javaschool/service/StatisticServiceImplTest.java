package javaschool.service;

import javaschool.dao.OrderProductDao;
import javaschool.dao.OrdersDao;
import javaschool.entities.OrderProduct;
import javaschool.entities.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Map;

public class StatisticServiceImplTest {
    StatisticService service;
    private OrderProductDao orderProductDaoMock;
    private OrdersDao ordersDaoMock;

    @Before
    public void setUp() throws Exception {
        StatisticServiceImpl statisticService = new StatisticServiceImpl();
        orderProductDaoMock = Mockito.mock(OrderProductDao.class);
        ordersDaoMock = Mockito.mock(OrdersDao.class);
        statisticService.setOrdersDao(ordersDaoMock);
        statisticService.setOrderProductDao(orderProductDaoMock);
        service = statisticService;
    }

    @Test
    public void testFindTopTenProducts() throws Exception {
        ArrayList<OrderProduct> orderList = new ArrayList<OrderProduct>();
        for (int i = 0; i < 100; i++) {
            orderList.add(getOrderProduct(i));
        }
        Mockito.doReturn(orderList).when(orderProductDaoMock).getOrderProducts();
        Map<Product, Long> topTenProducts = service.findTopTenProducts();
        Assert.assertEquals(10, topTenProducts.entrySet().size());
        long i = 20;
        for (Product product : topTenProducts.keySet()) {
            Assert.assertEquals(--i, (long) product.getId());
        }
    }

    private OrderProduct getOrderProduct(long i) {
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setId(i);
        Product productId = new Product();
        productId.setId(i % 20);
        orderProduct.setProductId(productId);
        orderProduct.setQuantity(i);
        return orderProduct;
    }

    @Test
    public void testFindTopTenClients() throws Exception {

    }

    @Test
    public void testOrdersForAWeeks() throws Exception {

    }
}