package com.webapp.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp.demo.Component.Location;

public interface Locationdao extends JpaRepository<Location, Integer> {

}
