package com.example.demo.security.userprincal;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.IUserRepository;

@Service
public class UserDetailService implements UserDetailsService{
    @Autowired
    IUserRepository userRepository;
    //Kiểm tra username or password
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User users=userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("User not found -> user name or password"+username));
        return UserPrinciple.build(users);
    }
   
}
