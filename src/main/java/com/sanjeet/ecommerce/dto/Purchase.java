package com.sanjeet.ecommerce.dto;

import java.util.Set;

import com.sanjeet.ecommerce.entity.Address;
import com.sanjeet.ecommerce.entity.Customer;
import com.sanjeet.ecommerce.entity.Order;
import com.sanjeet.ecommerce.entity.OrderItem;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Purchase {

	private Customer customer;
	private Address shippingAddress;
	private Address billingAddress;
	private Order order;
	private Set<OrderItem> orderItems;
}
