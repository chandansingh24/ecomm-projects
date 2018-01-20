package com.adminportal.service;

import java.util.List;

import com.adminportal.domain.Car;

public interface CarService {
     Car save(Car car); 
     
     List<Car> findAll();
     
     Car findOne(Long id);
     
     void removeOne(Long id);
     
}
