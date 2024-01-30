package com.altimetrik.adminservice.model;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
	
    private Long productId;

    @NotBlank(message = "name cannot be blank")
    @Size(min = 1, max = 10, message = "name must be between 1 and 10 characters")
    private String name;

    @NotBlank(message = "brand cannot be blank")
    @Size(min = 1, max = 10, message = "brand must be between 1 and 10 characters")
    private String brand;

    @NotBlank(message = "description cannot be blank")
    private String description;

    @NotBlank(message = "priceCurrency cannot be blank")
    @Size(min = 3, max = 3, message = "priceCurrency must be exactly 3 characters")
    private String priceCurrency;

    @NotNull(message = "priceAmount cannot be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "priceAmount must be greater than 0")
    private Double priceAmount;

    @NotNull(message = "inventoryTotal cannot be null")
    @Min(value = 0, message = "inventoryTotal must be greater than or equal to 0")
    private Integer inventoryTotal;

    @NotNull(message = "inventoryAvailable cannot be null")
    @Min(value = 0, message = "inventoryAvailable must be greater than or equal to 0")
    private Integer inventoryAvailable;

    @NotNull(message = "inventoryReserved cannot be null")
    @Min(value = 0, message = "inventoryReserved must be greater than or equal to 0")
    private Integer inventoryReserved;

    @NotNull(message = "categoryId cannot be null")
    private Long categoryId;
}
