package com.example.ecommerceadmindemo;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ProductPersistenceEntityModel.class)
public abstract class ProductPersistenceEntityModel_ {

	public static volatile SingularAttribute<ProductPersistenceEntityModel, String> images;
	public static volatile SingularAttribute<ProductPersistenceEntityModel, BigDecimal> price;
	public static volatile SingularAttribute<ProductPersistenceEntityModel, String> name;
	public static volatile SingularAttribute<ProductPersistenceEntityModel, String> description;
	public static volatile SingularAttribute<ProductPersistenceEntityModel, Integer> Id;
	public static volatile SingularAttribute<ProductPersistenceEntityModel, String> productType;

	public static final String IMAGES = "images";
	public static final String PRICE = "price";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String ID = "Id";
	public static final String PRODUCT_TYPE = "productType";

}

