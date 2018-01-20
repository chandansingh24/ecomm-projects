package com.comehomecar.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comehomecar.domain.UserPayment;
import com.comehomecar.repository.UserPaymentRepository;
import com.comehomecar.service.UserPaymentService;

@Service
public class UserPaymentServiceImpl implements UserPaymentService {
   
	@Autowired
	private UserPaymentRepository userPaymentRepository;
	
	@Override
	public UserPayment findById(Long id) {
		
		return userPaymentRepository.findOne(id);		
	}
	
	@Override
	public void removeById(Long id) {
		userPaymentRepository.delete(id);
	}


}
