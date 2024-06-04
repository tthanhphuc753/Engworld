package com.example.EngWorldBackend.Domain.Service.CategoryService;

import com.example.EngWorldBackend.Domain.Model.Categories;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Categories createCategory(Categories category);

    List<Categories> getAllCategories();

    Optional<Categories> getCategoryById(Long categoryId);

    Categories updateCategory(long id, Categories updatedCategory);

    void deleteCategory(Long categoryId);
}
