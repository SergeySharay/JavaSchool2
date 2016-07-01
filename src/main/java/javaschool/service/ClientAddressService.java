package javaschool.service;

import javaschool.entities.Client;
import javaschool.entities.ClientAddress;

public interface ClientAddressService extends GenericService<ClientAddress, Long> {

    ClientAddress getAddress(Client client);

    public void updateByClientAddress(ClientAddress clientAddress);

    ClientAddress addByClientAddress(ClientAddress clientAddress);
}

