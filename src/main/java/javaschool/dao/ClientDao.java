/**
 * @author Sergey Sharay
 * @version 1.0
 */
package javaschool.dao;

import javaschool.entities.Client;
import javaschool.entities.Orders;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ClientDao extends GenericDao<Client, Long> {

    List<Client> getClients() throws SQLException;

    Map<String, String> getClientEmailPassword() throws SQLException;

    Client getClient(String email) throws SQLException;

    Set<Orders> getOrders(final Client client) throws SQLException;

    List<Client> getPageClients(int pageNumber, int pageSize) throws SQLException;


}
