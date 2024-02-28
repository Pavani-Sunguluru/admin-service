package com.ecommerce.adminservice.service;

import java.util.List;

import com.ecommerce.adminservice.exception.ResourceNotFoundException;
import com.ecommerce.adminservice.model.ProductDTO;

public interface ProductService {
	List<ProductDTO> getAllProducts();

    ProductDTO getProductById(Long productId) throws ResourceNotFoundException;

    ProductDTO getProductByName(String productName) throws ResourceNotFoundException;

    ProductDTO addProduct(ProductDTO productDTO);

    ProductDTO updateProduct(Long productId, ProductDTO updatedProductDTO);

    void removeProduct(Long productId);
}
