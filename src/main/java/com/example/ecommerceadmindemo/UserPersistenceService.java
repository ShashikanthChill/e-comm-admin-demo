/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ecommerceadmindemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author The_Humble_Fool
 */
@Service
public class UserPersistenceService implements UserDetailsService {

    @Autowired
    UsersRepo repo;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        UserPersistenceEntityModel entityModel = repo.findByUsername(usernameOrEmail);

        if (entityModel == null) {
            entityModel = loadUserByEmail(usernameOrEmail);
            if (entityModel == null) {
                throw new UsernameNotFoundException("No user found with given username or email");
            }
        }

        return new UserDetailsImpl(entityModel);
    }

    public UserPersistenceEntityModel loadUserByEmail(String email) {
        return repo.findByEmail(email);
    }

    public UserPersistenceEntityModel loadUserById(int id) {
        return repo.findById(id).get();
    }

    public boolean userExistsByUsername(String username) {
        return repo.existsByUsername(username);
    }

    public boolean userExistsByEmail(String email) {
        return repo.existsByEmail(email);
    }

    public boolean userExistsByPhone(String phone) {
        return repo.existsByPhone(phone);
    }

    public boolean saveUser(UserPersistenceEntityModel entityModel) {
        UserPersistenceEntityModel savedEntityModel = repo.saveAndFlush(entityModel);
        if (savedEntityModel != null) {
            System.out.println("New user with id: " + savedEntityModel.getId() + ", username: " + savedEntityModel.getUsername() + " is saved into database.");
            return true;
        }
        System.out.println("something went wrong when saving user: " + entityModel.getUsername() + "  into database.");
        return false;
    }

}
