package javaschool.dao;

import javaschool.em.EntityManagerAc;
import javaschool.em.EntityManagerAcFactory;
import javaschool.em.EntityManagerAcImpl;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

/**
 * Created by Sergey on 26.06.2016.
 */
public class ProductDaoImplTest {

    @Before
    public void setUp() throws Exception {
        //EntityManager entityManagerAc = EntityManagerAcFactory.createEntityManagerAc();
    }

    @Test
    public void testGetProducts() throws Exception {
        ProductDaoImpl productDao = new ProductDaoImpl();
        System.out.println(productDao.getProducts());
    }

    @Test
    public void testGetBrands() throws Exception {
        ProductDaoImpl productDao = new ProductDaoImpl();
        System.out.println(productDao.getBrands());
    }
}