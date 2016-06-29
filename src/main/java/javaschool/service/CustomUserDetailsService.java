package javaschool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private UserManager userManager;

    @Autowired
    @Qualifier(value = "UserManager")
    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        return userManager.getUser(username);
    }

}