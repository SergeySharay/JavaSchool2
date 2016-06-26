/**
 * Generic Dao class for All entities.
 *
 * @author Sergey Sharay
 * @version 1.0
 */
package javaschool.dao;

import javaschool.em.EntityManagerAc;
import javaschool.em.EntityManagerAcFactory;
import org.apache.log4j.Logger;

import java.io.Serializable;

public class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK> {
    protected static Logger logger = Logger.getLogger(ClientAdressDaoImpl.class);

    private Class<T> type;
    /**
     * Class constructor.
     *
     * @param type An Entity.class
     */
    public GenericDaoImpl(Class<T> type) {
        this.type = type;
    }
    public EntityManagerAc getEntityManager() {
        return EntityManagerAcFactory.createEntityManagerAc();
    }
    /**
     * Add an entity to DB
     *
     * @param object An entity for adding
     * @return An entity from DB after adding
     */
    public T add(T object) {

        try (EntityManagerAc entityManager = getEntityManager()) {
            entityManager.getTransaction().begin();
            T objectFromDB = entityManager.merge(object);
            entityManager.getTransaction().commit();
            return objectFromDB;
        }
    }
    /**
     * Delete an entity from DB by Id.
     *
     * @param id Id from DB
     */
    public void delete(PK id) {
        try (EntityManagerAc entityManager = getEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.remove(get(id));
            entityManager.getTransaction().commit();
        }
    }
    /**
     * Get an entity from DB by Id.
     *
     * @param id Id from DB.
     * @return An Entity from DB.
     */
    public T get(PK id) {
        try (EntityManagerAc entityManager = getEntityManager()) {
            return entityManager.find(type, id);
        }
    }
    /**
     * Update current Entity in DB.
     *
     * @param object An Entity for update
     */
    public void update(T object) {
        try (EntityManagerAc entityManager = getEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.merge(object);
            entityManager.getTransaction().commit();
        }
    }
}
