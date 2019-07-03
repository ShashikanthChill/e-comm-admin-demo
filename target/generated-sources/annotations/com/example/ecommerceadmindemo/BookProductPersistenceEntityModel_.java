package com.example.ecommerceadmindemo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BookProductPersistenceEntityModel.class)
public abstract class BookProductPersistenceEntityModel_ extends com.example.ecommerceadmindemo.ProductPersistenceEntityModel_ {

	public static volatile SingularAttribute<BookProductPersistenceEntityModel, Integer> pages;
	public static volatile SingularAttribute<BookProductPersistenceEntityModel, String> author;
	public static volatile SingularAttribute<BookProductPersistenceEntityModel, String> isbn;
	public static volatile SingularAttribute<BookProductPersistenceEntityModel, Integer> edition;
	public static volatile SingularAttribute<BookProductPersistenceEntityModel, String> lang;

	public static final String PAGES = "pages";
	public static final String AUTHOR = "author";
	public static final String ISBN = "isbn";
	public static final String EDITION = "edition";
	public static final String LANG = "lang";

}

