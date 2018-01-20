package com.comehomecar.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.comehomecar.domain.Car;
import com.comehomecar.domain.CarToCartItem;
import com.comehomecar.domain.CartItem;
import com.comehomecar.domain.Order;
import com.comehomecar.domain.ShoppingCart;
import com.comehomecar.domain.User;
import com.comehomecar.repository.CarToCartItemRepository;
import com.comehomecar.repository.CartItemRepository;
import com.comehomecar.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService {
	
	@Autowired
	private CartItemRepository cartItemRepository;
	
	@Autowired
	private CarToCartItemRepository carToCartItemRepository;
	

	@Override
	public List<CartItem> findByShoppingCart(ShoppingCart shoppingCart) {
		return cartItemRepository.findByShoppingCart(shoppingCart);
	}


	@Override
	public CartItem updateCartItem(CartItem cartItem) {
		BigDecimal bigDecimal = new BigDecimal(cartItem.getCar().getOurPrice()).multiply(new BigDecimal(cartItem.getQty()));
		
		bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
		cartItem.setSubtotal(bigDecimal);
		
		cartItemRepository.save(cartItem);
		
		return cartItem;
	}


	@Override
	public CartItem addcarToCartItem(Car car, User user, int qty) {
		List<CartItem> cartItemList = findByShoppingCart(user.getShoppingCart());
		
		for (CartItem cartItem : cartItemList) {
			if(car.getId() == cartItem.getCar().getId()) {
				cartItem.setQty(cartItem.getQty() + qty);
				cartItem.setSubtotal(new BigDecimal(car.getOurPrice()).multiply(new BigDecimal(qty)));
				cartItemRepository.save(cartItem);
				return cartItem;
			}
		}
		
		CartItem cartItem = new CartItem();
		cartItem.setShoppingCart(user.getShoppingCart());
		cartItem.setCar(car);
		
		cartItem.setQty(qty);
		cartItem.setSubtotal(new BigDecimal(car.getOurPrice()).multiply(new BigDecimal(qty)));
		cartItem = cartItemRepository.save(cartItem);
		
		CarToCartItem carToCartItem = new CarToCartItem();
		carToCartItem.setCar(car);
		carToCartItem.setCartItem(cartItem);
		carToCartItemRepository.save(carToCartItem);
		
		return cartItem;			
		
	}


	@Override
	public CartItem findById(Long id) {
		return cartItemRepository.findOne(id);
	}


	@Override
	public void removeCartItem(CartItem cartItem) {
		carToCartItemRepository.deleteByCartItem(cartItem);
		cartItemRepository.delete(cartItem);
		
	}
	
	@Override
	public CartItem save(CartItem cartItem) {
		return cartItemRepository.save(cartItem);
	}


	@Override
	public List<CartItem> findByOrder(Order order) {
		return cartItemRepository.findByOrder(order);
	}
		
//	public List<CartItem> findByShoppingCart(ShoppingCart shoppingCart) {
//		return cartItemRepository.findByShoppingCart(shoppingCart);
//	}

	
}
