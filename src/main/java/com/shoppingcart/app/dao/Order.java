/*
 * package com.shoppingcart.app.dao;
 * 
 * import javax.persistence.Column; import javax.persistence.Entity; import
 * javax.persistence.GeneratedValue; import javax.persistence.GenerationType;
 * import javax.persistence.Id; import javax.persistence.Table;
 * 
 * import lombok.Data;
 * 
 * @Data
 * 
 * @Entity
 * 
 * @Table(name= "ORDER") public class Order {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.SEQUENCE)
 * 
 * @Column(name="order_no") int orderNo;
 * 
 * @Column(name="customer_id", nullable=false, length=5) int customerId;
 * 
 * @Column(name="vegetables", length=1000) String vegetableList;
 * 
 * }
 */