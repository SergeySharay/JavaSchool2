package javaschool.service;

import javaschool.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private HashMap<String, User> users;
    @Autowired
    @Qualifier(value = "ClientService")
    private ClientService clientDao;

    @Transactional
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        users = new HashMap<String, User>();

        Map<String, String> emailpass = null;
        emailpass = clientDao.getClientEmailPassword();
        for (Map.Entry entry : emailpass.entrySet())
            users.put((String) entry.getKey(), new User((String) entry.getKey(), (String) entry.getValue(), "ROLE_USER"));
        users.put("pow@pow.pow", new User("pow@pow.pow", "pow", "ROLE_USER, ROLE_ADMIN"));
        if (!users.containsKey(username)) {
            throw new UsernameNotFoundException(username + " not found");
        }
        return users.get(username);
    }

}