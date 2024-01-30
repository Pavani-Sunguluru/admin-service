package com.altimetrik.adminservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altimetrik.adminservice.entity.CategoryEntity;
import com.altimetrik.adminservice.exception.ResourceNotFoundException;
import com.altimetrik.adminservice.model.CategoryDTO;
import com.altimetrik.adminservice.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<CategoryEntity> categories = categoryRepository.findAll();
        return categories.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getCategoryById(Long categoryId) throws ResourceNotFoundException {
        return categoryRepository.findById(categoryId)
                .map(this::convertToDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found for the given categoryId"));
    }

    @Override
    public CategoryDTO getCategoryByName(String categoryName) throws ResourceNotFoundException {
        return categoryRepository.findByName(categoryName)
                .map(this::convertToDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found for the given categoryName"));
    }

    @Override
    public CategoryDTO addCategory(CategoryDTO categoryDTO) {
        CategoryEntity categoryEntity = convertToEntity(categoryDTO);
        CategoryEntity savedCategory = categoryRepository.save(categoryEntity);
        return convertToDTO(savedCategory);
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO) {
        CategoryEntity categoryEntity = convertToEntity(categoryDTO);
        CategoryEntity updatedCategory = categoryRepository.save(categoryEntity);
        return convertToDTO(updatedCategory);
    }

    @Override
    public void removeCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    private CategoryDTO convertToDTO(CategoryEntity categoryEntity) {
        return modelMapper.map(categoryEntity, CategoryDTO.class);
    }

    private CategoryEntity convertToEntity(CategoryDTO categoryDTO) {
        return modelMapper.map(categoryDTO, CategoryEntity.class);
    }
}
