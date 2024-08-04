package com.eletroproject.portalcarapi.controllers;

import com.eletroproject.portalcarapi.dto.BrandDTO;
import com.eletroproject.portalcarapi.entities.Brand;
import com.eletroproject.portalcarapi.services.BrandService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("/{id}")
    public ResponseEntity<Brand> getBrandById(@PathVariable Long id) {
        Brand brandObj = brandService.findById(id);
        return ResponseEntity.ok().body(brandObj);
    }

    @GetMapping
    public ResponseEntity<List<BrandDTO>> getAllBrands() {
        List<Brand> brandList = brandService.findAll();
        List<BrandDTO> brandListDTO = brandList.stream().map(brandObj -> new BrandDTO(brandObj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(brandListDTO);
    }

}
