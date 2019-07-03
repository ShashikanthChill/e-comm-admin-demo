package com.example.ecommerceadmindemo;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MobileProductPersistenceEntityModel.class)
public abstract class MobileProductPersistenceEntityModel_ extends com.example.ecommerceadmindemo.ProductPersistenceEntityModel_ {

	public static volatile SingularAttribute<MobileProductPersistenceEntityModel, String> colour;
	public static volatile SingularAttribute<MobileProductPersistenceEntityModel, BigDecimal> size;
	public static volatile SingularAttribute<MobileProductPersistenceEntityModel, String> os;
	public static volatile SingularAttribute<MobileProductPersistenceEntityModel, String> modelNumber;
	public static volatile SingularAttribute<MobileProductPersistenceEntityModel, Integer> storage;
	public static volatile SingularAttribute<MobileProductPersistenceEntityModel, Integer> battery;
	public static volatile SingularAttribute<MobileProductPersistenceEntityModel, String> processor;
	public static volatile SingularAttribute<MobileProductPersistenceEntityModel, String> manufacturer;
	public static volatile SingularAttribute<MobileProductPersistenceEntityModel, Integer> ram;

	public static final String COLOUR = "colour";
	public static final String SIZE = "size";
	public static final String OS = "os";
	public static final String MODEL_NUMBER = "modelNumber";
	public static final String STORAGE = "storage";
	public static final String BATTERY = "battery";
	public static final String PROCESSOR = "processor";
	public static final String MANUFACTURER = "manufacturer";
	public static final String RAM = "ram";

}

