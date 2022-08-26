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

@Table(name="ADMIN")
@Entity
@Data
public class Admin {
	
	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE)
	@Column(name="id")
	Integer adminId;
	
	@Column(name="name", length=50)
	String name;
	
	@Column(name="contact_number", length=10)
	Long contactNumber;
	
	@Column(name="email_id", length=50)
	String emailId;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date")
	private Date createDate;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modify_date")
	private Date modifyDate;

}
