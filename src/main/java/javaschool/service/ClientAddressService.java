package javaschool.service;

import javaschool.entities.Client;
import javaschool.entities.ClientAddress;

public interface ClientAddressService extends GenericService<ClientAddress, Long> {

    ClientAddress getAddress(Client client);

}

