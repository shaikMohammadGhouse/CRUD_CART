package com.shoppingcart.app.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shoppingcart.app.dao.Vegetable;

@Repository
public interface VegetableRepository extends JpaRepository<Vegetable, Integer>{

	@Query("select v from Vegetable v where (v.type = :type or :type is null or :type = '') and (v.unit = :unit or :unit is null or :unit = '' )")
	List<Vegetable> findAllByCombination(@Param("type") String type, @Param("unit") String unit);

	Set<Vegetable> findByvegIdIn(List<Integer> vegIds);

}
