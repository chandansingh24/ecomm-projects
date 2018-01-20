package com.comehomecar.repository;

import org.springframework.data.repository.CrudRepository;

import com.comehomecar.domain.Order;



public interface OrderRepository extends CrudRepository<Order, Long>{

}
