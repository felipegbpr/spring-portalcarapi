package com.eletroproject.portalcarapi.entities;



import com.eletroproject.portalcarapi.dto.CarDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "cars")
@Getter
@Setter
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String color;
	private String model;
	private String photo;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "brand_id")
	private Brand brand;
	
}