package com.ecommerce.adminservice.model;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
	
	private Long categoryId;

    @NotBlank(message = "name cannot be blank")
    @Size(min = 1, max = 10, message = "name must be between 1 and 10 characters")
    private String name;

    @NotBlank(message = "description cannot be blank")
    private String description;

    @Valid 
    private List<@Valid ProductDTO> products;
}