package com.webapp.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp.demo.Component.Product;

public interface Productdao extends JpaRepository<Product, Integer> {

}
