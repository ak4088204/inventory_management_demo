package com.webapp.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp.demo.Component.Sale;

public interface Saledao extends JpaRepository<Sale, Integer> {

}
