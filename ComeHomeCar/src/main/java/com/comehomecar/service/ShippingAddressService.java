package com.comehomecar.service;

import com.comehomecar.domain.ShippingAddress;
import com.comehomecar.domain.UserShipping;

public interface ShippingAddressService {
	
	ShippingAddress setByUserShipping(UserShipping userShipping, ShippingAddress shippingAddress);

}
