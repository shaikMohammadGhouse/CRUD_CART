
package com.shoppingcart.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoppingcart.app.dao.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}
