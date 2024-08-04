package com.eletroproject.portalcarapi.services;

import com.eletroproject.portalcarapi.dto.BrandDTO;
import com.eletroproject.portalcarapi.entities.Brand;
import com.eletroproject.portalcarapi.repositories.BrandRepository;
import com.eletroproject.portalcarapi.services.exceptions.DataIntegrityViolationException;
import com.eletroproject.portalcarapi.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService {
    @Autowired
    private BrandRepository repository;

    public Brand create(Brand brand) {
        return repository.save(brand);
    }

    public List<Brand> findAll() {
        return repository.findAll();
    }

    public Brand findById(Long id) {

        Optional<Brand> brandObj = repository.findById(id);
        return brandObj.orElseThrow(() -> new ObjectNotFoundException(
                "Object was not found. Id: " + id + " Type: " + Brand.class.getName()));
    }

    public Brand update(Long id, BrandDTO brandObjDTO) {
        Brand brandObj = findById(id);
        brandObj.setName(brandObjDTO.getName());
        brandObj.setCountry(brandObjDTO.getCountry());
        return repository.save(brandObj);
    }

    public void delete(Long id) {
        var brandObj = findById(id);

        if (!brandObj.getCars().isEmpty()) {
            throw new DataIntegrityViolationException("The brand cannot be erased! It has associated cars");
        } else {
            repository.deleteById(id);
        }
    }

}
