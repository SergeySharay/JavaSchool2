/**
 * Dao interface for all entities.
 *
 * @author Sergey Sharay
 * @version 1.0
 */
package javaschool.dao;

import java.io.Serializable;

public interface GenericDao<T, PK extends Serializable> {

    T add(T object);

    T get(PK id);

    void delete(PK id);

    void update(T object);

}
