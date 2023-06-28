package com.webapp.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp.demo.Component.PurchaseOrder;

public interface Purchaseorderdao extends JpaRepository<PurchaseOrder, Integer> {

}
