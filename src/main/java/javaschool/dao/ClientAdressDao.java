/**
 * @author Sergey Sharay
 * @version 1.0
 */
package javaschool.dao;

import javaschool.entities.Client;
import javaschool.entities.ClientAdress;

/**
 * Dao interface for ClientAdress entity.
 */
public interface ClientAdressDao extends GenericDao<ClientAdress, Long> {
    /**
     * @param client a Client entity
     * @return a ClientAdress entity
     */
    ClientAdress getAdress(Client client);
}
