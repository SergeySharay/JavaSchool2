/**
 * Dao class for Client entity.
 *
 * @author Sergey Sharay
 * @version 1.0
 */
package javaschool.dao;


import javaschool.em.EntityManagerAc;
import javaschool.entities.Client;
import javaschool.entities.Orders;

import javax.persistence.TypedQuery;
import java.util.*;

public class ClientDaoImpl extends GenericDaoImpl<Client, Long>
        implements ClientDao {
    /**
     * Class constructor.
     */
    public ClientDaoImpl() {
        super(Client.class);
    }

    /**
     * Get List of all clients.
     *
     * @return List of Client
     */
    public List<Client> getClients() {
        try (EntityManagerAc entityManager = getEntityManager()) {
            entityManager.getTransaction().begin();
            TypedQuery<Client> namedQuery = entityManager.createNamedQuery("Client.getClients", Client.class);
            entityManager.getTransaction().commit();
            return namedQuery.getResultList();
        }


    }

    /**
     * Get Map of all Emails and Passwords.
     *
     * @return <code>Map(Email ,Password) </code>
     */
    public Map<String, String> getClientEmailPassword() {
        try (EntityManagerAc entityManager = getEntityManager()) {
            Map<String, String> clienEmailPassword = new HashMap<String, String>();
            entityManager.getTransaction().begin();
            TypedQuery<Client> namedQuery = entityManager.createNamedQuery("Client.getClients", Client.class);
            for (Client client : namedQuery.getResultList()) {
                clienEmailPassword.put(client.getEmail(), client.getPassword());
            }
            entityManager.getTransaction().commit();
            return clienEmailPassword;
        }
    }

    /**
     * Get a single Client for Email.
     *
     * @param email Client Email
     * @return Client client
     */
    public Client getClient(final String email) {
        try (EntityManagerAc entityManager = getEntityManager()) {
            entityManager.getTransaction().begin();
            TypedQuery<Client> namedQuery = entityManager.createNamedQuery("Client.getClient", Client.class);
            namedQuery.setParameter("email", email);
            entityManager.getTransaction().commit();
            if (namedQuery.getResultList().size() == 0) {
                return null;
            } else {
                return namedQuery.getSingleResult();
            }
        }
    }

    /**
     * Get a set of Orders for Client.
     *
     * @param client a Client for set orders
     * @return HashSet of Orders for single Client
     */
    public Set<Orders> getOrders(final Client client) {
        try (EntityManagerAc entityManager = getEntityManager()) {
            entityManager.getTransaction().begin();
            TypedQuery<Orders> namedQuery = entityManager.createNamedQuery("Client.getOrders", Orders.class);
            namedQuery.setParameter("client", client);
            entityManager.getTransaction().commit();
            return new HashSet<Orders>(namedQuery.getResultList());
        }
    }
}
