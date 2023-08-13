package com.electronic.store.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private long product_Id;
	private String product_Name;
	private String product_Seller;
	private double product_price;
	

}
