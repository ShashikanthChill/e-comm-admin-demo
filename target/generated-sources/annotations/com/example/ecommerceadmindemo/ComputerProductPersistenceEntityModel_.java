package com.example.ecommerceadmindemo;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ComputerProductPersistenceEntityModel.class)
public abstract class ComputerProductPersistenceEntityModel_ extends com.example.ecommerceadmindemo.ProductPersistenceEntityModel_ {

	public static volatile SingularAttribute<ComputerProductPersistenceEntityModel, String> colour;
	public static volatile SingularAttribute<ComputerProductPersistenceEntityModel, BigDecimal> size;
	public static volatile SingularAttribute<ComputerProductPersistenceEntityModel, String> os;
	public static volatile SingularAttribute<ComputerProductPersistenceEntityModel, String> graphics;
	public static volatile SingularAttribute<ComputerProductPersistenceEntityModel, Integer> storage;
	public static volatile SingularAttribute<ComputerProductPersistenceEntityModel, Integer> battery;
	public static volatile SingularAttribute<ComputerProductPersistenceEntityModel, String> processor;
	public static volatile SingularAttribute<ComputerProductPersistenceEntityModel, String> manufacturer;
	public static volatile SingularAttribute<ComputerProductPersistenceEntityModel, Integer> ram;

	public static final String COLOUR = "colour";
	public static final String SIZE = "size";
	public static final String OS = "os";
	public static final String GRAPHICS = "graphics";
	public static final String STORAGE = "storage";
	public static final String BATTERY = "battery";
	public static final String PROCESSOR = "processor";
	public static final String MANUFACTURER = "manufacturer";
	public static final String RAM = "ram";

}

