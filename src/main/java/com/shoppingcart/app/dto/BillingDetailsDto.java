package com.shoppingcart.app.dto;

import java.util.Date;

import lombok.Data;
@Data
public class BillingDetailsDto {
	int billingId;
	int orderId;
	String transactionMode;
	Date transactionDate;
	String transactionStatus;
	AddressDto billingAddress;
	
	
}
