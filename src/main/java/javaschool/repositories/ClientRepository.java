package javaschool.repositories;
import javaschool.entities.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface ClientRepository extends CrudRepository<Client,Long> {

    Map<String,String> getClientEmailPassword();
}
