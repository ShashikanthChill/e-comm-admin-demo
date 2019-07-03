/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ecommerceadmindemo;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author The_Humble_Fool
 */
@Entity
@DiscriminatorValue(value = "book")
public class BookProductPersistenceEntityModel extends ProductPersistenceEntityModel {

    @Column(name = "isbn", unique = true)
    private String isbn;

    @Column(name = "author")
    private String author;

    @Column(name = "edition")
    private int edition;

    @Column(name = "pages")
    private int pages;

    @Column(name = "lang")
    private String lang;

    public BookProductPersistenceEntityModel() {
    }

    public BookProductPersistenceEntityModel(String isbn, String author, int edition, int pages, String lang) {
        this.isbn = isbn;
        this.author = author;
        this.edition = edition;
        this.pages = pages;
        this.lang = lang;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getEdition() {
        return this.edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

//    @Override
//    public String toString() {
//        return "BookProductPersistenceEntityModel{" + "isbn=" + isbn + ", author=" + author + ", edition=" + edition + ", pages=" + pages + ", lang=" + lang + '}';
//    }

    @Override
    public String toString() {
        return "BookProductPersistenceEntityModel: {" + "id=" + super.getId() + ", isbn=" + isbn + ", author=" + author + ", edition=" + edition + ", pages=" + pages + ", lang=" + lang + '}';
    }
    
    

}
