package com.eletroproject.portalcarapi.controllers;

import com.eletroproject.portalcarapi.dto.CarDTO;
import com.eletroproject.portalcarapi.entities.Car;
import com.eletroproject.portalcarapi.services.CarService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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

	@GetMapping("/all")
	public ResponseEntity<List<CarDTO>> getAllCars() {
		List<Car> carsList = carService.findAll();
		List<CarDTO> carslistDTO = carsList.stream().map(carObj -> new CarDTO(carObj)).collect(Collectors.toList());

		return ResponseEntity.ok().body(carslistDTO);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Car> getAllCars(@PathVariable Long id) {
		Car carObj = carService.findById(id);
		return ResponseEntity.ok().body(carObj);
	}

	@GetMapping
	public ResponseEntity<List<CarDTO>> getAllCarsByBrand(@RequestParam(value = "brand", defaultValue = "0") Long brand_id) {
		List<Car> carList = carService.findAllByBrandId(brand_id);
		List<CarDTO> carListDTO = carList.stream().map(carObj -> new CarDTO(carObj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(carListDTO);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Car> updateCar(@PathVariable Long id, @Valid @RequestBody Car carObj) {
		Car newCarObj = carService.update(id, carObj);
		return ResponseEntity.ok().body(newCarObj);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Car> updatePatchCar(@PathVariable Long id, @Valid @RequestBody Car carObj) {
		Car newCarObj = carService.update(id, carObj);
		return ResponseEntity.ok().body(newCarObj);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Car> delete(@PathVariable Long id) {
		carService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
