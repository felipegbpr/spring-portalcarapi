package com.eletroproject.portalcarapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eletroproject.portalcarapi.entities.Car;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    @Query("SELECT c FROM Car c WHERE c.brand.id = :brand_id ORDER BY model")
    List<Car> findAllByBrandId(@Param(value = "brand_id") Long brand_id);
}
