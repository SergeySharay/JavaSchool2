package javaschool.service;

import javaschool.dao.GenericDao;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.sql.SQLException;

@Service("GenericService")
public class GenericServiceImpl<T, PK extends Serializable> implements GenericService<T, PK> {
    private static final org.apache.log4j.Logger logger = Logger.getLogger(GenericServiceImpl.class);

    private GenericDao<T, PK> genericDao;

    @Autowired
    @Qualifier(value = "GenericDao")
    public void setGenericDao(GenericDao<T, PK> genericDao) {
        this.genericDao = genericDao;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public T add(T object) {
        try {
            return genericDao.add(object);
        } catch (SQLException e) {
            logger.error("Exception occurred during GenericService.add() call");
            return null;
        }
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public T get(PK id) {
        try {
            return genericDao.get(id);
        } catch (SQLException e) {
            logger.error("Exception occurred during GenericService.get() call");
            return null;
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void delete(PK id) {
        try {
            genericDao.delete(id);
        } catch (SQLException e) {
            logger.error("Exception occurred during GenericService.delete() call");
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void update(T object) {
        try {
            genericDao.update(object);
        } catch (SQLException e) {
            logger.error("Exception occurred during GenericService.update() call");
        }
    }
}
