package com.altimetrik.adminservice.service;

import java.util.List;

import com.altimetrik.adminservice.exception.ResourceNotFoundException;
import com.altimetrik.adminservice.model.ProductDTO;

public interface ProductService {
	List<ProductDTO> getAllProducts();

    ProductDTO getProductById(Long productId) throws ResourceNotFoundException;

    ProductDTO getProductByName(String productName) throws ResourceNotFoundException;

    ProductDTO addProduct(ProductDTO productDTO);

    ProductDTO updateProduct(Long productId, ProductDTO updatedProductDTO);

    void removeProduct(Long productId);
}
