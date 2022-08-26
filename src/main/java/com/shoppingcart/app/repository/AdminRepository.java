package com.shoppingcart.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoppingcart.app.dao.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

}
