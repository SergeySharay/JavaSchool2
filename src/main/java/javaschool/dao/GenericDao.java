/**
 * Dao interface for all entities.
 *
 * @author Sergey Sharay
 * @version 1.0
 */
package javaschool.dao;

import java.io.Serializable;

/**
 * Generic Dao interface for All entities.
 */
public interface GenericDao<T, PK extends Serializable> {

    /**
     * Save an object to DB
     *
     * @param object object for adding to DB
     * @return object from DB after adding
     */
    T add(T object);

    T get(PK id);

    void delete(PK id);

    void update(T object);

}
