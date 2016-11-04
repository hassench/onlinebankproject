/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer.service;

import BusinessLayer.exception.UsernameNotFoundException;
import BusinessLayer.model.CustomSecurityUser;
import BusinessLayer.model.Utilisateur;
import DataBaseAcessLayer.UserDAO;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;


public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private UserDAO userDAO;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Utilisateur user = userDAO.findUserByName(username); //our own User model class

        if (user != null) {
            String password = user.getPass();
            //additional information on the security object
            boolean enabled = user.getEnabled().equals(Boolean.TRUE);
            boolean accountNonExpired = user.getEnabled().equals(Boolean.TRUE);
            boolean credentialsNonExpired = user.getEnabled().equals(Boolean.TRUE);
            boolean accountNonLocked = user.getEnabled().equals(Boolean.TRUE);

            //Let's populate user roles
            Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

            authorities.add(new GrantedAuthorityImpl(user.getRole()));

            //Now let's create Spring Security User object
            CustomSecurityUser securityUser = new CustomSecurityUser(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities, user.getId());
            return securityUser;
        } else {
            throw new UsernameNotFoundException("User Not Found");
        }
    }

}
