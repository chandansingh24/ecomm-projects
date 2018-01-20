package com.comehomecar.repository;

import org.springframework.data.repository.CrudRepository;

import com.comehomecar.domain.ShoppingCart;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {

}
