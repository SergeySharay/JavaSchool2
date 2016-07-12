package javaschool.service;

import javaschool.dao.ClientAddressDao;
import javaschool.entities.Client;
import javaschool.entities.ClientAddress;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service("ClientAddressService")
@Transactional
public class ClientAddressServiceImpl extends GenericServiceImpl<ClientAddress, Long> implements ClientAddressService {
    private static final org.apache.log4j.Logger logger = Logger.getLogger(ClientAddressServiceImpl.class);

    private ClientAddressDao clientAddressDao;

    @Autowired
    @Qualifier(value = "ClientAddressDao")
    public void setClientAddressDao(ClientAddressDao clientAddressDao) {
        this.clientAddressDao = clientAddressDao;
    }

    public ClientAddress getAddress(Client client) {
        try {
            return clientAddressDao.getAddress(client);
        } catch (SQLException e) {
            logger.error("Exception occurred during ClientAddressService.getAddress() call");
            return null;
        }
    }

    public void updateByClientAddress(ClientAddress clientAddress) {
        try {
            clientAddressDao.update(clientAddress);
        } catch (SQLException e) {
            logger.error("Exception occurred during ClientAddressService.updateByClientAddress() call");
        }
    }

    public ClientAddress addByClientAddress(ClientAddress clientAddress) {
        try {
            return clientAddressDao.add(clientAddress);
        } catch (SQLException e) {
            logger.error("Exception occurred during ClientAddressService.addByClientAddress() call");
            return null;
        }
    }
}
