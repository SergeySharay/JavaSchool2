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
import java.sql.SQLException;
import java.util.*;

@Repository("ClientDao")
public class ClientDaoImpl extends GenericDaoImpl<Client, Long> implements ClientDao {
    public ClientDaoImpl() {
        super(javaschool.entities.Client.class);
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Client> getClients() throws SQLException {
        try {
            TypedQuery<Client> namedQuery = entityManager.createNamedQuery("Client.getClients", Client.class);
            return namedQuery.getResultList();
        } catch (Exception ex) {
            throw new SQLException("Exception occurred in ClientDao.getClients()", ex);
        }
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Map<String, String> getClientEmailPassword() throws SQLException {
        try {
            Map<String, String> clienEmailPassword = new HashMap<String, String>();
            TypedQuery<Client> namedQuery = entityManager.createNamedQuery("Client.getClients", Client.class);
            for (Client client : namedQuery.getResultList()) {
                clienEmailPassword.put(client.getEmail(), client.getPassword());
            }
            return clienEmailPassword;
        } catch (Exception ex) {
            throw new SQLException("Exception occurred in ClientDao.getClientEmailPassword()", ex);
        }
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Client getClient(final String email) throws SQLException {
        try {
            TypedQuery<Client> namedQuery = entityManager.createNamedQuery("Client.getClient", Client.class);
            namedQuery.setParameter("email", email);
            if (namedQuery.getResultList().size() == 0) {
                return null;
            } else {
                return namedQuery.getSingleResult();
            }
        } catch (Exception ex) {
            throw new SQLException("Exception occurred in ClientDao.getClient()", ex);
        }
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Set<Orders> getOrders(final Client client) throws SQLException {
        try {
            TypedQuery<Orders> namedQuery = entityManager.createNamedQuery("Client.getOrders", Orders.class);
            namedQuery.setParameter("client", client);
            return new LinkedHashSet<Orders>(namedQuery.getResultList());
        } catch (Exception ex) {
            throw new SQLException("Exception occurred in ClientDao.getOrders()", ex);
        }
    }

    public List<Client> getPageClients(int pageNumber, int pageSize) throws SQLException {
        try {
            TypedQuery<Client> namedQuery = entityManager.createNamedQuery("Client.getClients", Client.class);
            namedQuery.setFirstResult((pageNumber - 1) * pageSize);
            namedQuery.setMaxResults(pageSize);
            return namedQuery.getResultList();
        } catch (Exception ex) {
            throw new SQLException("Exception occurred in ClientDao.getPageClients()", ex);
        }
    }
}