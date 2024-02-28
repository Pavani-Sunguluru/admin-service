package com.ecommerce.adminservice.service;

import java.util.List;

import com.ecommerce.adminservice.exception.ResourceNotFoundException;
import com.ecommerce.adminservice.model.CategoryDTO;

public interface CategoryService {
	List<CategoryDTO> getAllCategories();

    CategoryDTO getCategoryById(Long categoryId) throws ResourceNotFoundException;

    CategoryDTO getCategoryByName(String categoryName) throws ResourceNotFoundException;

    CategoryDTO addCategory(CategoryDTO categoryDTO);

    CategoryDTO updateCategory(CategoryDTO categoryDTO);

    void removeCategory(Long categoryId);

}
