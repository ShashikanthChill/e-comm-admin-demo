/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ecommerceadmindemo;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author The_Humble_Fool
 */
@Repository
public interface AllProductTypeProductsRepo extends JpaRepository<AllProductTypeProductPersistenceEntityModel, Integer> {

    List<AllProductTypeProductPersistenceEntityModel> findAllByProductType(String productType, Pageable pageable);

}
