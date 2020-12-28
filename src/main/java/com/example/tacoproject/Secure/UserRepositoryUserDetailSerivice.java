package com.example.tacoproject.Secure;

import com.example.tacoproject.Data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserRepositoryUserDetailSerivice  implements UserDetailsService {

    private UserRepository userRepo;

    @Autowired
    public UserRepositoryUserDetailSerivice(UserRepository userRepo)
    {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        UserForm userForm = userRepo.findByUsername(userName);
        if ( userForm == null  )
        {
            throw new UsernameNotFoundException("User: " + userName+ " not found");
        }

        return userForm;
    }
}
