package com.comehomecar.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.comehomecar.domain.Car;
import com.comehomecar.repository.CarRepository;
import com.comehomecar.service.CarService;

@Service
public class CarServiceImpl implements CarService {
	@Autowired
	private CarRepository carRepository;
	
	@Override
	public List<Car> findAll() {
	 List<Car> carList = (List<Car>) carRepository.findAll();
	 List<Car> activeCarList = new ArrayList<>(); 
	 
	 for (Car car: carList) {
			if(car.isActive()) {
				activeCarList.add(car);
			}
		}
	 return activeCarList;
	}
	
    @Override
	public Car findOne(Long id) {
    	   return carRepository.findOne(id);
    }

	@Override
	public List<Car> findByCategory(String category) {
       
		List<Car> carList = carRepository.findByCategory(category);
		
		List<Car> activeCarList = new ArrayList<>();
		
		for (Car car: carList) {
			if(car.isActive()) {
				activeCarList.add(car);
			}
		}
		
		return activeCarList;
	}
	
    
	@Override
	public List<Car> blurrySearch(String title) {
		List<Car> carList = carRepository.findByTitleContaining(title);
		
        List<Car> activeCarList = new ArrayList<>();
		
		for (Car car: carList) {
			if(car.isActive()) {
				activeCarList.add(car);
			}
		}
		
		return activeCarList;
	}
}
