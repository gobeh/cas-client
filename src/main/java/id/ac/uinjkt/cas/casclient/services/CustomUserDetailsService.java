package id.ac.uinjkt.cas.casclient.services;

import id.ac.uinjkt.cas.casclient.dao.UsersDao;
import id.ac.uinjkt.cas.casclient.entity.MyUserDetails;
import id.ac.uinjkt.cas.casclient.entity.UsersApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersDao ud;

    @Override
    public UserDetails loadUserByUsername(String emailString) throws UsernameNotFoundException {

        UsersApp users = ud.findByEmailUsers(emailString);
        if (users == null) {
            System.out.println("User not found or not actvated");
            throw new UsernameNotFoundException(emailString);
        }
        return new MyUserDetails(users);
    }

}
