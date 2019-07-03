/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ecommerceadmindemo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author The_Humble_Fool
 */
@Entity
@Table(name = "product_types")
public class ProductTypesPersistenceEntityModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "product_type")
    private String productType;

    @Column(name = "type_name")
    private String typeName;

    @Column(name = "description")
    private String description;

    @Column(name = "images")
    private String images;

    public ProductTypesPersistenceEntityModel() {
    }

    public ProductTypesPersistenceEntityModel(Integer id) {
        this.id = id;
    }

    public ProductTypesPersistenceEntityModel(Integer id, String productType, String typeName) {
        this.id = id;
        this.productType = productType;
        this.typeName = typeName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "ProductTypesPersistenceEntityModel: {" + "id=" + id + ", productType=" + productType + ", typeName=" + typeName + ", description=" + description + ", images=" + images + '}';
    }

}
