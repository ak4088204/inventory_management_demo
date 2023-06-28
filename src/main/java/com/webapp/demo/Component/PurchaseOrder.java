package com.webapp.demo.Component;

import java.util.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class PurchaseOrder {
    
	@Id
	@GeneratedValue(generator = "pur",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "pur",sequenceName = "purchase",initialValue = 1,allocationSize = 1)
	private int id;
	private int productId;
	private int quantity;
	private String supplier;
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
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
}
