package com.comehomecar.service;

import com.comehomecar.domain.Payment;
import com.comehomecar.domain.UserPayment;

public interface PaymentService {
	Payment setByUserPayment(UserPayment userPayment, Payment payment);
}
