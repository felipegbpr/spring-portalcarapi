package com.eletroproject.portalcarapi.controllers;

import com.eletroproject.portalcarapi.dto.CarDTO;
import com.eletroproject.portalcarapi.entities.Brand;
import com.eletroproject.portalcarapi.entities.Car;
import com.eletroproject.portalcarapi.services.CarService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cars")
public class CarController {

	@Autowired
	private CarService carService;

	@PostMapping
	@Transactional
	public ResponseEntity<Car> createCar(
			@RequestParam(value = "brand", defaultValue = "0") Long id_brand,
			@Valid @RequestBody Car carObj) {

			Car newCar = carService.create(id_brand, carObj);
			URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/cars/{id}").buildAndExpand(newCar.getId()).toUri();
			return ResponseEntity.created(uri).build();
	}

	@GetMapping()
	public ResponseEntity<List<CarDTO>> getCars() {
		List<Car> carsList = carService.findAll();
		List<CarDTO> carslistDTO = carsList.stream().map(carObj -> new CarDTO(carObj)).collect(Collectors.toList());

		return ResponseEntity.ok().body(carslistDTO);
	}

}
