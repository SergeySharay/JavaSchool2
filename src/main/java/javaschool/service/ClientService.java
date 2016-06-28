package javaschool.service;

import javaschool.entities.Client;

import java.util.List;
import java.util.Map;

public interface ClientService extends GenericService<Client, Long> {

    List<Client> getClients();

    Map<String, String> getClientEmailPassword();

    Client getClient(String email);

}

