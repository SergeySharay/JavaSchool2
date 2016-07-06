/**
 * @author Sergey Sharay
 * @version 1.0
 */
package javaschool.selenium;

import javaschool.entities.Client;
import javaschool.entities.Orders;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ClientDao extends GenericDao<Client, Long> {

    List<Client> getClients();

    Map<String, String> getClientEmailPassword();

    Client getClient(String email);

    Set<Orders> getOrders(final Client client);

    List<Client> getPageClients(int pageNumber, int pageSize);


}
