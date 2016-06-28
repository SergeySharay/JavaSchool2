/**
 * @author Sergey Sharay
 * @version 1.0
 */
package javaschool.dao;

import javaschool.entities.Client;
import javaschool.entities.ClientAddress;

public interface ClientAddressDao extends GenericDao<ClientAddress, Long> {

    ClientAddress getAddress(Client client);

}
