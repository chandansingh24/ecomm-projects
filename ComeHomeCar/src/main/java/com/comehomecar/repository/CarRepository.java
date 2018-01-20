package com.comehomecar.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.comehomecar.domain.Car;

public interface CarRepository extends CrudRepository<Car, Long>  {
	 List<Car> findByCategory(String category); 
	 
	 List<Car> findByTitleContaining(String title); 
}
