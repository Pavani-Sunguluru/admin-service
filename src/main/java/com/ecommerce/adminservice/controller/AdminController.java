package com.ecommerce.adminservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.adminservice.exception.ResourceNotFoundException;
import com.ecommerce.adminservice.model.CategoryDTO;
import com.ecommerce.adminservice.model.ProductDTO;
import com.ecommerce.adminservice.service.CategoryService;
import com.ecommerce.adminservice.service.ProductService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;



@RestController
@RequestMapping("/admin")
public class AdminController {

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @GetMapping("/categories")
    public List<CategoryDTO> getAllCategories() {
    	logger.info("Entered AdminController:getAllCategories()");
        return categoryService.getAllCategories();
    }

    @GetMapping("/categories/{categoryId}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable @Valid @NotNull(message = "Category ID cannot be null") @Positive(message = "Category ID must be positive")  Long categoryId) throws ResourceNotFoundException {
        CategoryDTO category = categoryService.getCategoryById(categoryId);
        return ResponseEntity.ok(category);
    }

    @GetMapping("/categories/byName/{categoryName}")
    public ResponseEntity<CategoryDTO> getCategoryByName(@PathVariable String categoryName) throws ResourceNotFoundException {
        CategoryDTO category = categoryService.getCategoryByName(categoryName);
        return ResponseEntity.ok(category);
    }

    @PostMapping("/addCategory")
    public ResponseEntity<CategoryDTO> addCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        CategoryDTO addedCategory = categoryService.addCategory(categoryDTO);
        return ResponseEntity.ok(addedCategory);
    }

    @PutMapping("/updateCategory")
    public ResponseEntity<CategoryDTO> updateCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        CategoryDTO updatedCategory = categoryService.updateCategory(categoryDTO);
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/removeCategory/{categoryId}")
    public ResponseEntity<String> removeCategory(@PathVariable Long categoryId) {
        categoryService.removeCategory(categoryId);
        return ResponseEntity.ok("Category removed successfully");
    }

    @GetMapping("/products")
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long productId) throws ResourceNotFoundException {
        ProductDTO product = productService.getProductById(productId);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/products/byName/{productName}")
    public ResponseEntity<ProductDTO> getProductByName(@PathVariable String productName) throws ResourceNotFoundException {
        ProductDTO product = productService.getProductByName(productName);
        return ResponseEntity.ok(product);
    }

    @PostMapping("/addProduct")
    public ResponseEntity<ProductDTO> addProduct(@Valid @RequestBody ProductDTO productDTO) {
        ProductDTO addedProduct = productService.addProduct(productDTO);
        return ResponseEntity.ok(addedProduct);
    }

    @PutMapping("/updateProduct/{productId}")
    public ResponseEntity<ProductDTO> updateProduct(@Valid @PathVariable Long productId, @RequestBody ProductDTO updatedProductDTO) {
        ProductDTO updatedProduct = productService.updateProduct(productId, updatedProductDTO);
        if (updatedProduct != null) {
            return ResponseEntity.ok(updatedProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/removeProduct/{productId}")
    public ResponseEntity<String> removeProduct(@PathVariable Long productId) {
        productService.removeProduct(productId);
        return ResponseEntity.ok("Product removed successfully");
    }

}

