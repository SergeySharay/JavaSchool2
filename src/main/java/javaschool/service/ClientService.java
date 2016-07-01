package javaschool.service;

import javaschool.entities.Client;
import javaschool.entities.Orders;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ClientService extends GenericService<Client, Long> {

    List<Client> getClients();

    Map<String, String> getClientEmailPassword();

    Client getClient(String email);

    Set<Orders> getOrders(final Client client);

    public void updateByClient(Client client);

    Client addByClient(Client client);
}

