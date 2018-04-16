package com.myauto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myauto.entity.AppUser;
import com.myauto.repository.UserRepository;

@Service
public class UserManagementService implements UserManagement {

    private final UserRepository userRepository;
    
    @Autowired
    public UserManagementService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Override
    @Transactional
    public void addUser(AppUser user) {
        userRepository.add(user);
    }

}
