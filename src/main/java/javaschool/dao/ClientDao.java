/**
 * @author Sergey Sharay
 * @version 1.0
 */
package javaschool.dao;

import javaschool.entities.Client;

import java.util.List;
import java.util.Map;

public interface ClientDao extends GenericDao<Client, Long> {

    List<Client> getClients();

    Map<String, String> getClientEmailPassword();

    Client getClient(String email);

}
