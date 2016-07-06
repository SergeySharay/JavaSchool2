package javaschool.service;

import javaschool.entities.Client;
import javaschool.entities.Orders;
import javaschool.selenium.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service("ClientService")
@Transactional
public class ClientServiceImpl extends GenericServiceImpl<Client, Long> implements ClientService {
    private ClientDao clientDao;

    @Autowired
    @Qualifier(value = "ClientDao")
    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public List<Client> getClients() {
        return clientDao.getClients();
    }

    public Map<String, String> getClientEmailPassword() {
        return clientDao.getClientEmailPassword();
    }

    public Client getClient(String email) {
        return clientDao.getClient(email);
    }

    public Set<Orders> getOrders(Client client) {
        return clientDao.getOrders(client);
    }

    public void updateByClient(Client client) {
        clientDao.update(client);
    }

    public Client addByClient(Client client) {
        return clientDao.add(client);
    }

    public List<Client> getPageClients(int pageNumber, int pageSize) {
        return clientDao.getPageClients(pageNumber, pageSize);
    }


}
