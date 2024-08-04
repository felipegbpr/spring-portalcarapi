package com.eletroproject.portalcarapi.services;

import com.eletroproject.portalcarapi.entities.Brand;
import com.eletroproject.portalcarapi.entities.Car;
import com.eletroproject.portalcarapi.repositories.CarRepository;
import com.eletroproject.portalcarapi.services.exceptions.ObjectNotFoundException;
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

	public Car findById(Long id) {
		Optional<Car> brandObj = repository.findById(id);
		return brandObj.orElseThrow(() -> new ObjectNotFoundException(
				"Object was not found. Id: " + id + "Type: " + Car.class.getName()));
	}

	public List<Car> findAllByBrandId(Long brand_id) {
		brandService.findById(brand_id);
		return repository.findAllByBrandId(brand_id);
	}

}
