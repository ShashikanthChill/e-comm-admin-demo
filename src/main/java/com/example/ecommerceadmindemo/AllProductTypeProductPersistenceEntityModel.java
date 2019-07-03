/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ecommerceadmindemo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author The_Humble_Fool
 */
@Entity
@Table(name = "products")
public class AllProductTypeProductPersistenceEntityModel implements Serializable {

    @Column(name = "product_type")
    private String productType;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "description")
    private String description;

    @Column(name = "name")
    private String name;

    @Column(name = "price", scale = 2)
    private BigDecimal price;

    @Column(name = "images")
    private String images;

    @Column(name = "author")
    private String author;

    @Column(name = "edition")
    private Integer edition;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "lang")
    private String lang;

    @Column(name = "pages")
    private Integer pages;

    @Column(name = "battery")
    private Integer battery;

    @Column(name = "colour")
    private String colour;

    @Column(name = "graphics")
    private String graphics;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "os")
    private String os;

    @Column(name = "processor")
    private String processor;

    @Column(name = "ram")
    private Integer ram;

    @Column(name = "size")
    private BigDecimal size;

    @Column(name = "storage")
    private Integer storage;

    @Column(name = "model_number")
    private String modelNumber;

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getEdition() {
        return edition;
    }

    public void setEdition(Integer edition) {
        this.edition = edition;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getBattery() {
        return battery;
    }

    public void setBattery(Integer battery) {
        this.battery = battery;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getGraphics() {
        return graphics;
    }

    public void setGraphics(String graphics) {
        this.graphics = graphics;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public BigDecimal getSize() {
        return size;
    }

    public void setSize(BigDecimal size) {
        this.size = size;
    }

    public Integer getStorage() {
        return storage;
    }

    public void setStorage(Integer storage) {
        this.storage = storage;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    @Override
    public String toString() {
        return "ProductPersistenceEntityModel_1: {" + "productType=" + productType + ", id=" + id + ", description=" + description + ", name=" + name + ", price=" + price + ", images=" + images + ", author=" + author + ", edition=" + edition + ", isbn=" + isbn + ", lang=" + lang + ", pages=" + pages + ", battery=" + battery + ", colour=" + colour + ", graphics=" + graphics + ", manufacturer=" + manufacturer + ", os=" + os + ", processor=" + processor + ", ram=" + ram + ", size=" + size + ", storage=" + storage + ", modelNumber=" + modelNumber + '}';
    }

}
