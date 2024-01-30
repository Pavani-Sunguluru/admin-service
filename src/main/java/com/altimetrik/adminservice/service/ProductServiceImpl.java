package com.altimetrik.adminservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altimetrik.adminservice.entity.ProductEntity;
import com.altimetrik.adminservice.exception.ResourceNotFoundException;
import com.altimetrik.adminservice.model.ProductDTO;
import com.altimetrik.adminservice.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ProductDTO> getAllProducts() {
        List<ProductEntity> products = productRepository.findAll();
        return products.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProductById(Long productId) throws ResourceNotFoundException {
        return productRepository.findById(productId)
                .map(this::convertToDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found for the given categoryName"));
    }

    @Override
    public ProductDTO getProductByName(String productName) throws ResourceNotFoundException {
        return productRepository.findByName(productName)
                .map(this::convertToDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found for the given categoryName"));
    }

    @Override
    public ProductDTO addProduct(ProductDTO productDTO) {
        ProductEntity productEntity = convertToEntity(productDTO);
        ProductEntity savedProduct = productRepository.save(productEntity);
        return convertToDTO(savedProduct);
    }

    @Override
    public ProductDTO updateProduct(Long productId, ProductDTO updatedProductDTO) {
        ProductEntity existingProduct = productRepository.findById(productId).orElse(null);
        if (existingProduct != null) {
            modelMapper.map(updatedProductDTO, existingProduct);
            ProductEntity updatedProduct = productRepository.save(existingProduct);
            return convertToDTO(updatedProduct);
        }
        return null;
    }

    @Override
    public void removeProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    private ProductDTO convertToDTO(ProductEntity productEntity) {
        return modelMapper.map(productEntity, ProductDTO.class);
    }

    private ProductEntity convertToEntity(ProductDTO productDTO) {
        return modelMapper.map(productDTO, ProductEntity.class);
    }
}
