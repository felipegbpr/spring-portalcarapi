package com.eletroproject.portalcarapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eletroproject.portalcarapi.entities.Car;
import com.eletroproject.portalcarapi.services.impl.CarService;

@RestController
@RequestMapping("/api/cars")
public class CarController {

	@Autowired
	private CarService carService;

	@GetMapping()
	public List<Car> getCars() {
		return this.carService.findAll();
	}

	@PostMapping()
	public Car saveCar(@RequestBody Car car) {
		return this.carService.save(car);
	}

}
