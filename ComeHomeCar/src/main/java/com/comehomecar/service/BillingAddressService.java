package com.comehomecar.service;

import com.comehomecar.domain.BillingAddress;
import com.comehomecar.domain.UserBilling;

public interface BillingAddressService {
	BillingAddress setByUserBilling(UserBilling userBilling, BillingAddress billingAddress);
}
