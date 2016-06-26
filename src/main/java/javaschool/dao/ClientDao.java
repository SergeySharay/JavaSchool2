/**
 * @author Sergey Sharay
 * @version 1.0
 */
package javaschool.dao;

import javaschool.entities.Client;

import java.util.List;
import java.util.Map;

/**
 * Dao interface for Client entity.
 */
public interface ClientDao extends GenericDao<Client, Long> {
    /**
     * @return a List of all Clients in DB
     */
    List<Client> getClients();

    /**
     * @return a Map of all pair Email - Password for client from DB.
     */
    Map<String, String> getClientEmailPassword();

    /**
     * @param email email for finding a client in DB.
     * @return a Client entity for current email.
     */
    Client getClient(String email);

}
