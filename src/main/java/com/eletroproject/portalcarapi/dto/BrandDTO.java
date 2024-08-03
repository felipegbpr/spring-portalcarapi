package com.eletroproject.portalcarapi.dto;

import com.eletroproject.portalcarapi.entities.Brand;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.Length;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BrandDTO {

        private Long id;

        @NotEmpty(message = "Name is required.")
        @Length(min = 3, max = 100, message = "The NAME field must be between 3 and 100 characters long")
        private String name;

        @NotEmpty(message = "Country is required.")
        @Length(min = 3, max = 100, message = "The COUNTRY field must be between 3 and 100 characters long")
        private String country;

}
