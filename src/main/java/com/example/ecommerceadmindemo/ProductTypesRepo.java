/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ecommerceadmindemo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author The_Humble_Fool
 */
public interface ProductTypesRepo extends JpaRepository<ProductTypesPersistenceEntityModel, Integer> {

    @Query("select p.typeName from ProductTypesPersistenceEntityModel p")
    List<String> findTypeNames();

    @Query("select p.productType from ProductTypesPersistenceEntityModel p where p.typeName=:typeName")
    String findTypeOnName(String typeName);

    @Query("select p.typeName from ProductTypesPersistenceEntityModel p where p.productType=:productType")
    String findNameOnType(String productType);
}
