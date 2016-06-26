/**
 * Dao class for ClientAdress entity.
 *
 * @author Sergey Sharay
 * @version 1.0
 */
package javaschool.dao;

import javaschool.em.EntityManagerAc;
import javaschool.entities.Client;
import javaschool.entities.ClientAdress;

import javax.persistence.TypedQuery;

/**
 * Dao class for ClientAdress entity.
 */
public class ClientAdressDaoImpl extends GenericDaoImpl<ClientAdress, Long> implements ClientAdressDao {

    /**
     * Class constructor.
     */
    public ClientAdressDaoImpl() {
        super(ClientAdress.class);
    }

    /**
     * @param client a Client entity
     * @return a ClientAdress entity
     */
    public ClientAdress getAdress(final Client client) {
        try (EntityManagerAc entityManager = getEntityManager()) {
            entityManager.getTransaction().begin();
            TypedQuery<ClientAdress> namedQuery = entityManager.createNamedQuery("ClientAdress.getAdress", ClientAdress.class);
            namedQuery.setParameter("client", client);
            entityManager.getTransaction().commit();
            if (namedQuery.getSingleResult() != null) {
                return namedQuery.getSingleResult();
            } else {
                return new ClientAdress();
            }
        }
    }
}
