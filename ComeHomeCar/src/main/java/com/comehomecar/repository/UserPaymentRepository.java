package com.comehomecar.repository;

import org.springframework.data.repository.CrudRepository;

import com.comehomecar.domain.UserPayment;

public interface UserPaymentRepository extends CrudRepository<UserPayment, Long> {

}
