package com.altimetrik.adminservice.service;

import java.util.List;

import com.altimetrik.adminservice.exception.ResourceNotFoundException;
import com.altimetrik.adminservice.model.CategoryDTO;

public interface CategoryService {
	List<CategoryDTO> getAllCategories();

    CategoryDTO getCategoryById(Long categoryId) throws ResourceNotFoundException;

    CategoryDTO getCategoryByName(String categoryName) throws ResourceNotFoundException;

    CategoryDTO addCategory(CategoryDTO categoryDTO);

    CategoryDTO updateCategory(CategoryDTO categoryDTO);

    void removeCategory(Long categoryId);

}
