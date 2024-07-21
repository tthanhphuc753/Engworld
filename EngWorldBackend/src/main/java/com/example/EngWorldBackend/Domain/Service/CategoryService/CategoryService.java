package com.example.EngWorldBackend.Domain.Service.CategoryService;

import com.example.EngWorldBackend.Domain.Model.Categories;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Categories createCategory(Categories category);

    Page<Categories> getAllCategories(int pageNumber, int pageSize);

    Optional<Categories> getCategoryById(Long categoryId);

    Categories updateCategory(long id, Categories updatedCategory);

    void deleteCategory(Long categoryId);
}
