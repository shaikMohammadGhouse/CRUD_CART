package com.shoppingcart.app.dao;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Table(name="CUSTOMER")
@Entity
@Data
public class Customer {
	
	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE)
	@Column(name="id")
	Integer customerId;
	
	@Column(name="name", length=20)
	String name;
	
	@Column(name="mobile_number", length=10)
	String mobileNumber;
	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address", referencedColumnName = "id")
    private Address address;
	
	@Column(name="email_id", length=55)
	String emailId;
	
	@Column(name="password", length=20)
	String password;
	
	@Column(name="confirm_password", length=20)
	String confirmPassword;
	
	@OneToOne(mappedBy = "customer")
	private Cart cart;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date")
	private Date createDate;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modify_date")
	private Date modifyDate;
}
