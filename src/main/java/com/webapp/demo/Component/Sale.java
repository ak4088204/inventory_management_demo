package com.webapp.demo.Component;

import java.util.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;



@Entity
public class Sale {
	
	
@Id	
@GeneratedValue(generator = "sale",strategy = GenerationType.AUTO)
@SequenceGenerator(name = "sale",sequenceName = "salesss",initialValue = 1,allocationSize = 1)
private int id;
private int productId;
private int quantity;
private double price;
private Date timestamp;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public Date getTimestamp() {
	return timestamp;
}
public void setTimestamp(Date timestamp) {
	this.timestamp = timestamp;
}
}
