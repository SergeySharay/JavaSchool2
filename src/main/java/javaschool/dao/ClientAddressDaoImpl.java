/**
 * Dao class for ClientAddress entity.
 *
 * @author Sergey Sharay
 * @version 1.0
 */
package javaschool.dao;

import javaschool.entities.Client;
import javaschool.entities.ClientAddress;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;

@Repository("ClientAddressDao")
public class ClientAddressDaoImpl extends GenericDaoImpl<ClientAddress, Long> implements ClientAddressDao {
    public ClientAddressDaoImpl() {
        super(ClientAddress.class);
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public ClientAddress getAddress(final Client client) {
        try {
            TypedQuery<ClientAddress> namedQuery = entityManager.createNamedQuery("ClientAdress.getAdress", ClientAddress.class);
            namedQuery.setParameter("client", client);
            if (namedQuery.getSingleResult() != null) {
                return namedQuery.getSingleResult();
            } else {
                return new ClientAddress();
            }
        } catch (Exception e) {
            System.out.println("ClientAddressDaoImpl.getAdress error:" + e.getMessage());
            return null;
        }
    }
}
