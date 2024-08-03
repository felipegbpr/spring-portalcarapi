package com.eletroproject.portalcarapi.services;

import com.eletroproject.portalcarapi.entities.Brand;
import com.eletroproject.portalcarapi.entities.Car;
import com.eletroproject.portalcarapi.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
	
	@Autowired
	private CarRepository repository;

	@Autowired
	private BrandService brandService;

	public Car create(Long id_brand, Car carObj) {
		carObj.setId(null);
		Brand brand = brandService.findById(id_brand);
		carObj.setBrand(brand);
		return repository.save(carObj);
	}

	public List<Car> findAll() {
		return repository.findAll();
	}

	public Car findById(Long carId) {
		// TODO Auto-generated method stub
		return null;
	}

}
