package com.webapp.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp.demo.Component.Shipment;

public interface Shipmentdao extends JpaRepository<Shipment, Integer> {

}
