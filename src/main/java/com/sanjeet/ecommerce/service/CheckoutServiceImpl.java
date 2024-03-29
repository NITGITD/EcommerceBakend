package com.sanjeet.ecommerce.service;

import java.util.Set;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanjeet.ecommerce.dto.Purchase;
import com.sanjeet.ecommerce.dto.PurchaseResponse;
import com.sanjeet.ecommerce.entity.Customer;
import com.sanjeet.ecommerce.entity.Order;
import com.sanjeet.ecommerce.entity.OrderItem;
import com.sanjeet.ecommerce.repository.CustomerRepository;

@Service
public class CheckoutServiceImpl implements CheckoutService {

	
	private CustomerRepository customerRepository;
	@Autowired
	public CheckoutServiceImpl(CustomerRepository customerRepository) {
		// TODO Auto-generated constructor stub
		this.customerRepository=customerRepository;
	}
	@Override
	@Transactional
	public PurchaseResponse placeOrder(Purchase purchase) {
		
		 Order order=purchase.getOrder();
		 
		 String orderTrackingNumber=generateOrderTrackingNumber(); 
		 order.setOrderTrackingNumber(orderTrackingNumber);
		Set<OrderItem> orderItems=purchase.getOrderItems();
		orderItems.forEach(item->order.add(item));
		
		order.setBillingAddress(purchase.getBillingAddress());
		order.setShippingAddress(purchase.getShippingAddress());
		
		Customer customer=purchase.getCustomer();
		customer.add(order);
		
		customerRepository.save(customer);
		return new PurchaseResponse(orderTrackingNumber);
	}

	private String generateOrderTrackingNumber() {
		
		return UUID.randomUUID().toString();
	}

}
