/**
 * Dao interface for all entities.
 *
 * @author Sergey Sharay
 * @version 1.0
 */
package javaschool.dao;

import java.io.Serializable;
import java.sql.SQLException;

public interface GenericDao<T, PK extends Serializable> {

    T add(T object) throws SQLException;

    T get(PK id) throws SQLException;

    void delete(PK id) throws SQLException;

    void update(T object) throws SQLException;

}
