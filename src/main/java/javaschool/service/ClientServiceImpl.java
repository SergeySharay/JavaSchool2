package javaschool.service;

import javaschool.dao.ClientDao;
import javaschool.entities.Client;
import javaschool.entities.Orders;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service("ClientService")
@Transactional
public class ClientServiceImpl extends GenericServiceImpl<Client, Long> implements ClientService {
    private static final org.apache.log4j.Logger logger = Logger.getLogger(ClientServiceImpl.class);

    private ClientDao clientDao;

    @Autowired
    @Qualifier(value = "ClientDao")
    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public List<Client> getClients() {
        try {
            return clientDao.getClients();
        } catch (SQLException e) {
            logger.error("Exception occurred during ClientService.setClientDao() call");
            return null;
        }
    }

    public Map<String, String> getClientEmailPassword() {
        try {
            return clientDao.getClientEmailPassword();
        } catch (SQLException e) {
            logger.error("Exception occurred during ClientService.getClientEmailPassword() call");
            return null;
        }
    }

    public Client getClient(String email) {
        try {
            return clientDao.getClient(email);
        } catch (SQLException e) {
            logger.error("Exception occurred during ClientService.getClient() call");
            return null;
        }
    }

    public Set<Orders> getOrders(Client client) {
        try {
            return clientDao.getOrders(client);
        } catch (SQLException e) {
            logger.error("Exception occurred during ClientService.getOrders() call");
            return null;
        }
    }

    public void updateByClient(Client client) {
        try {
            clientDao.update(client);
        } catch (SQLException e) {
            logger.error("Exception occurred during ClientService.updateByClient() call");
        }
    }

    public Client addByClient(Client client) {
        try {
            return clientDao.add(client);
        } catch (SQLException e) {
            logger.error("Exception occurred during ClientService.updateByClient() call");
            return null;
        }
    }

    public List<Client> getPageClients(int pageNumber, int pageSize) {
        try {
            return clientDao.getPageClients(pageNumber, pageSize);
        } catch (SQLException e) {
            logger.error("Exception occurred during ClientService.updateByClient() call");
            return null;
        }
    }
}
