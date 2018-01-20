package com.comehomecar.service;

import java.util.List;

import com.comehomecar.domain.Car;

public interface CarService {
	
	List<Car> findAll();
	
	Car findOne(Long id);
	
	List<Car> findByCategory(String category);
	
	List<Car> blurrySearch(String title);
}
