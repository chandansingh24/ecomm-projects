package com.comehomecar.service;

import java.util.List;

import com.comehomecar.domain.Car;
import com.comehomecar.domain.CartItem;
import com.comehomecar.domain.Order;
import com.comehomecar.domain.ShoppingCart;
import com.comehomecar.domain.User;



public interface CartItemService {
	List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);
	
	CartItem updateCartItem(CartItem cartItem);
	
	CartItem addcarToCartItem(Car car, User user, int qty);
	
	CartItem findById(Long id);
	
	void removeCartItem(CartItem cartItem);
	
	CartItem save(CartItem cartItem);
	
	List<CartItem> findByOrder(Order order);
}
