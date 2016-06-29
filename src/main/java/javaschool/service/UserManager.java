package javaschool.service;

import javaschool.dao.ClientDao;
import javaschool.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service("UserManager")
public class UserManager {
    private HashMap<String, User> users;
    private ClientDao clientDao;

    public UserManager() {
        users = new HashMap<String, User>();
        //Map<String, String> emailpass = clientDao.getClientEmailPassword();
/*
            for (Map.Entry entry : emailpass.entrySet())
                users.put((String) entry.getKey(), new User((String) entry.getKey(), (String) entry.getValue(), "ROLE_USER"));
        } else {
*/
        users.put("2@2", new User("2@2", "2", "ROLE_USER, ROLE_ADMIN"));

    }

    @Autowired
    @Qualifier(value = "ClientDao")
    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public User getUser(String username) throws UsernameNotFoundException {
        if (!users.containsKey(username)) {
            throw new UsernameNotFoundException(username + " not found");
        }

        return users.get(username);
    }
}