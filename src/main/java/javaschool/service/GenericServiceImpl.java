package javaschool.service;

import javaschool.selenium.GenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Service("GenericService")
public class GenericServiceImpl<T, PK extends Serializable> implements GenericService<T, PK> {

    private GenericDao<T, PK> genericDao;

    @Autowired
    @Qualifier(value = "GenericDao")
    public void setGenericDao(GenericDao<T, PK> genericDao) {
        this.genericDao = genericDao;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public T add(T object) {
        return genericDao.add(object);
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public T get(PK id) {
        return genericDao.get(id);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void delete(PK id) {
        genericDao.delete(id);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void update(T object) {
        genericDao.update(object);
    }
}
