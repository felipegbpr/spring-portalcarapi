package com.eletroproject.portalcarapi.services;

import java.util.List;

import com.eletroproject.portalcarapi.entities.Car;

public interface ICarService {
	
	public Car save(Car car);
	public List<Car> findAll();
	public Car findById(Long carId);

}
