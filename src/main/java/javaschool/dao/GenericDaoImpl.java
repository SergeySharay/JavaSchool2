/**
 * Generic Dao class for All entities.
 *
 * @author Sergey Sharay
 * @version 1.0
 */
package javaschool.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.sql.SQLException;

@Repository("GenericDao")
public class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK> {
    private static final Logger logger = Logger.getLogger(GenericDaoImpl.class);
    protected EntityManager entityManager;
    private Class<T> type;

    public GenericDaoImpl() {
    }

    public GenericDaoImpl(Class<T> type) {
        this.type = type;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public T add(T object) throws SQLException {
        try {
            T objectFromDB = this.entityManager.merge(object);
            return objectFromDB;
        } catch (Exception ex) {
            throw new SQLException("Exception occurred in GenericDao.add()", ex);
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void delete(PK id) throws SQLException {
        try {
            this.entityManager.remove(get(id));
        } catch (Exception ex) {
            throw new SQLException("Exception occurred in GenericDao.delete()", ex);
        }
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public T get(PK id) throws SQLException {
        try {
            return this.entityManager.find(type, id);
        } catch (Exception ex) {
            throw new SQLException("Exception occurred in GenericDao.get()", ex);
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void update(T object) throws SQLException {
        try {
            this.entityManager.merge(object);
        } catch (Exception ex) {
            throw new SQLException("Exception occurred in GenericDao.update()", ex);
        }
    }
}
