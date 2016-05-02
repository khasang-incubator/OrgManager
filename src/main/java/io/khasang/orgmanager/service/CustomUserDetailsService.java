package io.khasang.orgmanager.service;

import io.khasang.orgmanager.dao.IUserDao;
import io.khasang.orgmanager.model.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    IUserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user=userDao.getUserByName(s);
        if(user==null) {
            throw new UsernameNotFoundException("user not found");
        }
        UserDetails userDetails=new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(),
                true, true, true, true, getGrantedAuthorities(user));
        return userDetails;
    }

    List<GrantedAuthority> getGrantedAuthorities(User user){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().getName()));
        // ADMIN has USER authority
        if(user.getRole().getName().equals("ADMIN")){
            authorities.add(new SimpleGrantedAuthority("USER"));
        }
        return authorities;
    }
}
