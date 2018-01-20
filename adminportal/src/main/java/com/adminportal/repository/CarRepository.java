package com.adminportal.repository;


import org.springframework.data.repository.CrudRepository;

import com.adminportal.domain.Car;

public interface CarRepository extends CrudRepository<Car, Long> {

}
