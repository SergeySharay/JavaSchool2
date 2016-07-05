/**
 * Dao class for Client entity.
 *
 * @author Sergey Sharay
 * @version 1.0
 */
package javaschool.dao;


import javaschool.entities.Client;
import javaschool.entities.Orders;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.*;

@Repository("ClientDao")
public class ClientDaoImpl extends GenericDaoImpl<Client, Long> implements ClientDao {
    public ClientDaoImpl() {
        super(javaschool.entities.Client.class);
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Client> getClients() {
        try {
            TypedQuery<Client> namedQuery = entityManager.createNamedQuery("Client.getClients", Client.class);
            return namedQuery.getResultList();
        } catch (Exception e) {
            System.out.println("ClientDaoImpl.getClients error:" + e.getMessage());
            return null;
        }
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Map<String, String> getClientEmailPassword() {
        try {
            Map<String, String> clienEmailPassword = new HashMap<String, String>();
            TypedQuery<Client> namedQuery = entityManager.createNamedQuery("Client.getClients", Client.class);
            for (Client client : namedQuery.getResultList()) {
                clienEmailPassword.put(client.getEmail(), client.getPassword());
            }
            return clienEmailPassword;
        } catch (Exception e) {
            System.out.println("ClientDaoImpl.getClientEmailPassword error:" + e.getMessage());
            return null;
        }
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Client getClient(final String email) {
        try {
            TypedQuery<Client> namedQuery = entityManager.createNamedQuery("Client.getClient", Client.class);
            namedQuery.setParameter("email", email);
            if (namedQuery.getResultList().size() == 0) {
                return null;
            } else {
                return namedQuery.getSingleResult();
            }
        } catch (Exception e) {
            System.out.println("ClientDaoImpl.getClient error:" + e.getMessage());
            return null;
        }
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Set<Orders> getOrders(final Client client) {
        try {
            TypedQuery<Orders> namedQuery = entityManager.createNamedQuery("Client.getOrders", Orders.class);
            namedQuery.setParameter("client", client);
            return new LinkedHashSet<Orders>(namedQuery.getResultList());
        } catch (Exception e) {
            System.out.println("ClientDaoImpl.getOrders error:" + e.getMessage());
            return null;
        }
    }

    public List<Client> getPageClients(int pageNumber, int pageSize) {
        TypedQuery<Client> namedQuery = entityManager.createNamedQuery("Client.getClients", Client.class);
        namedQuery.setFirstResult((pageNumber - 1) * pageSize);
        namedQuery.setMaxResults(pageSize);
        return namedQuery.getResultList();
    }
}
