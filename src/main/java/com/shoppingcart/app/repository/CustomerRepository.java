package com.shoppingcart.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingcart.app.dao.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
