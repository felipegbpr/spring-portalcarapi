package com.eletroproject.portalcarapi.dto;

import com.eletroproject.portalcarapi.entities.Car;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {

        private Long id;

        @NotEmpty(message = "Name is required.")
        @Length(min = 3, max = 100, message = "The NAME field must be between 3 and 100 characters long")
        private String name;

        @NotEmpty(message = "color is required.")
        @Length(min = 3, max = 50, message = "The NAME field must be between 3 and 50 characters long")
        String color;

        @NotEmpty(message = "Model is required.")
        @Length(min = 3, max = 100, message = "The MODEL field must be between 3 and 100 characters long")
        private String model;

        @NotBlank(message = "Photo is required.")
        @Length(min = 3, max = 200, message = "The PHOTO field must be between 3 and 200 characters long")
        private String photo;

        public CarDTO(Car carObj) {
                super();
                this.id = carObj.getId();
                this.name = carObj.getName();
                this.color = carObj.getColor();
                this.model = carObj.getModel();
                this.photo = carObj.getPhoto();
        }

}
