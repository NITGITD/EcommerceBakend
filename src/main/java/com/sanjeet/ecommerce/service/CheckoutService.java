package com.sanjeet.ecommerce.service;

import com.sanjeet.ecommerce.dto.Purchase;
import com.sanjeet.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {

	PurchaseResponse placeOrder(Purchase purchase);
}
