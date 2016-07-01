package javaschool.service;

import javaschool.dao.ClientAddressDao;
import javaschool.entities.Client;
import javaschool.entities.ClientAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("ClientAddressService")
@Transactional
public class ClientAddressServiceImpl extends GenericServiceImpl<ClientAddress, Long> implements ClientAddressService {

    private ClientAddressDao clientAddressDao;

    @Autowired
    @Qualifier(value = "ClientAddressDao")
    public void setClientAddressDao(ClientAddressDao clientAddressDao) {
        this.clientAddressDao = clientAddressDao;
    }

    public ClientAddress getAddress(Client client) {
        return clientAddressDao.getAddress(client);
    }

    public void updateByClientAddress(ClientAddress clientAddress) {
        clientAddressDao.update(clientAddress);
    }

    public ClientAddress addByClientAddress(ClientAddress clientAddress) {
        return clientAddressDao.add(clientAddress);
    }
}
