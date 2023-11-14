package com.eletroproject.portalcarapi.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eletroproject.portalcarapi.entities.Car;
import com.eletroproject.portalcarapi.repositories.CarRepository;
import com.eletroproject.portalcarapi.services.ICarService;

@Service
public class CarService implements ICarService {
	
	@Autowired
	private CarRepository repository;

	@Override
	public Car save(Car car) {
		return this.repository.save(car);
	}

	@Override
	public List<Car> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Car findById(Long carId) {
		// TODO Auto-generated method stub
		return null;
	}

}
