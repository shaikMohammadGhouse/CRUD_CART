package com.shoppingcart.app.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Table(name="BILLING_DETAILS")
@Entity
@Data
public class BillingDetails {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="billing_id")
	Integer billingId;
		
	@Column(name = "order_id", nullable = false)
	Integer orderId;
	
	@Column(name="transaction_mode" , length=100)
	String transactionMode;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="transaction_date", nullable=false)
	Date transactionDate;
	
	@Column(name="transaction_status", nullable=false, length=22)
	String transactionStatus;
	
	@Column(name="billing_address", length=100)
	String billingAddress;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date")
	private Date createDate;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modify_date")
	private Date modifyDate;
}
