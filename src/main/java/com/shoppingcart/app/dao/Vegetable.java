package com.shoppingcart.app.dao;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Table(name="VEGETABLE")
@Entity
public class Vegetable {
	
	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE)
	@Column(name="id")
	Integer vegId;
	
	@Column(name="name", length=22)
	String name;
	
	@Column(name="type", length=22)
	String type;
	
	@Column(name="price")
	BigDecimal price;
	
	@Column(name="quantity", length=22)
	Integer quantity;
	
	@Column(name="comment", length=22)
	String comment;
	
	@Column(name="unit", length=10)
	String unit;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date")
	private Date createDate;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modify_date")
	private Date modifyDate;
	
	@ManyToOne
    @JoinColumn(name="cart_id", nullable=false)
    private Cart cart;

}
