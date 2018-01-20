package com.comehomecar.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comehomecar.domain.UserShipping;
import com.comehomecar.repository.UserShippingRepository;
import com.comehomecar.service.UserShippingService;

@Service
public class UserShippingServiceImpl implements UserShippingService {

	@Autowired
	private UserShippingRepository userShippingRepository;
	
	public UserShipping findById(Long id) {
		return userShippingRepository.findOne(id); 
	}
	

	@Override
	public void removeById(Long id) {
		userShippingRepository.delete(id);
		
	}
	
	
	
}
