/**
 * Generic Dao class for All entities.
 *
 * @author Sergey Sharay
 * @version 1.0
 */
package javaschool.selenium;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

@Repository("GenericDao")
public class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK> {

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
    public T add(T object) {

        try {
            T objectFromDB = this.entityManager.merge(object);
            return objectFromDB;
        } catch (Exception e) {
            System.out.println("GenericDao.add error:" + e.getMessage());
            return null;
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void delete(PK id) {
        try {
            this.entityManager.remove(get(id));
        } catch (Exception e) {
            System.out.println("GenericDao.delete error:" + e.getMessage());
        }
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public T get(PK id) {
        try {
            return this.entityManager.find(type, id);
        } catch (Exception e) {
            System.out.println("GenericDao.get error:" + e.getMessage());
            return null;
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void update(T object) {
        try {
            this.entityManager.merge(object);
        } catch (Exception e) {
            System.out.println("GenericDao.update error:" + e.getMessage());
        }
    }
}
