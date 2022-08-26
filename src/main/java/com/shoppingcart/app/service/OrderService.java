package com.shoppingcart.app.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shoppingcart.app.dto.OrderDto;

@Service
public interface OrderService {

	OrderDto addOrder(OrderDto order);
	OrderDto viewOrder(OrderDto order);
	OrderDto updateOrder(OrderDto order);
	OrderDto viewAllOrder(int custId);
	OrderDto viewAllOrders(Date date);
	List<OrderDto> viewOrderList();
	OrderDto cancelOrder(int orderId);
}
