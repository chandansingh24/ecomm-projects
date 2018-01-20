package com.comehomecar.service;

import com.comehomecar.domain.UserPayment;

public interface UserPaymentService {
	
	UserPayment findById(Long id);
	
	void removeById(Long id);

}
