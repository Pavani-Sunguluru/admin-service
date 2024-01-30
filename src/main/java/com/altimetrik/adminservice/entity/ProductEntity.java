package com.altimetrik.adminservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String name;
    private String brand;
    private String description;
    private String priceCurrency;
    private Double priceAmount;
    private Integer inventoryTotal;
    private Integer inventoryAvailable;
    private Integer inventoryReserved;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;
}