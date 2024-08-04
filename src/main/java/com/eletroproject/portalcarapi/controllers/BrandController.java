package com.eletroproject.portalcarapi.controllers;

import com.eletroproject.portalcarapi.entities.Brand;
import com.eletroproject.portalcarapi.services.BrandService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping
    public ResponseEntity<Brand> createBrand(@Valid @RequestBody Brand brandObj) {
        brandObj = brandService.create(brandObj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(brandObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }


}
