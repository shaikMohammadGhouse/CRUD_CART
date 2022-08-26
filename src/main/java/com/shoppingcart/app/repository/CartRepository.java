package com.shoppingcart.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shoppingcart.app.dao.Cart;


@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{

	@Query("select c from Cart c where (c.status in :statuses) and (c.customer.customerId= :customerId)")
	Optional<Cart> getOpenCart(@Param("statuses") List<String> statuses, @Param("customerId") Integer customerId);

	/*
	 * @Query(nativeQuery =true,value = "SELECT * FROM Employee as e WHERE e.employeeName IN (:names)")   // 3. Spring JPA In cause using native query
	 */
}
