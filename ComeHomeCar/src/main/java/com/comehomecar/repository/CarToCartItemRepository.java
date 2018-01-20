package com.comehomecar.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.comehomecar.domain.CarToCartItem;
import com.comehomecar.domain.CartItem;

@Transactional
public interface CarToCartItemRepository extends CrudRepository<CarToCartItem, Long> {
     void deleteByCartItem(CartItem cartItem);
}
