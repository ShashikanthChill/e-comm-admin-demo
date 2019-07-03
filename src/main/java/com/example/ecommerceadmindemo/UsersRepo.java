/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ecommerceadmindemo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author The_Humble_Fool
 */
@Repository
public interface UsersRepo extends JpaRepository<UserPersistenceEntityModel, Integer> {

    UserPersistenceEntityModel findByUsername(String username);

    UserPersistenceEntityModel findByEmail(String email);

    boolean existsByPhone(String phone);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

}
