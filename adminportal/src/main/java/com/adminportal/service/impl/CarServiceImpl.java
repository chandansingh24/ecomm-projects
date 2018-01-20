package com.adminportal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminportal.domain.Car;
import com.adminportal.repository.CarRepository;
import com.adminportal.service.CarService;

@Service
public class CarServiceImpl implements CarService {
	
	@Autowired
	private CarRepository carRepository;

	@Override
	public Car save(Car car) {
		
		return carRepository.save(car);
		
	}

	@Override
	public List<Car> findAll() {
		return (List<Car>)carRepository.findAll();
	}
	
	@Override
	public Car findOne(Long id) {
		return carRepository.findOne(id);
	}

	@Override
	public void removeOne(Long id) {
		carRepository.delete(id);		
	}
		
	
}
