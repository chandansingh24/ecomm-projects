package com.comehomecar.service;

import com.comehomecar.domain.BillingAddress;
import com.comehomecar.domain.Order;
import com.comehomecar.domain.Payment;
import com.comehomecar.domain.ShippingAddress;
import com.comehomecar.domain.ShoppingCart;
import com.comehomecar.domain.User;

public interface OrderService {
	Order createOrder(ShoppingCart shoppingCart,
			ShippingAddress shippingAddress,
			BillingAddress billingAddress,
			Payment payment,
			String shippingMethod,
			User user);
	
	Order findOne(Long id);
}
