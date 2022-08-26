package com.shoppingcart.app.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name="USER")
@Entity
public class User {
	@Id
	@Column(name="id")
	String userId;
	
	@Column(name="name", length=50)
	String password;
	
	@Column(name="role", length=5)
	String role;
}
