package com.example.EngWorldBackend.Domain.Service.CategoryService;


import com.example.EngWorldBackend.Domain.Model.Categories;
import com.example.EngWorldBackend.Persistence.DAO.CategoriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoriesRepository categoriesRepository;

    @Override
    public Categories createCategory(Categories category) {
        return categoriesRepository.save(category);
    }

    @Override
    public List<Categories> getAllCategories() {
        return categoriesRepository.findAll();
    }

    @Override
    public Optional<Categories> getCategoryById(Long categoryId) {
        return categoriesRepository.findById(categoryId);
    }

    @Override
    public Categories updateCategory(long id, Categories updatedCategory) {
        Optional<Categories> optionalCategory = categoriesRepository.findById(id);
        if (optionalCategory.isPresent()) {
            Categories existingCategory = optionalCategory.get();
            existingCategory.setCategoryname(updatedCategory.getCategoryname());
            existingCategory.setExerciseList(updatedCategory.getExerciseList());
            existingCategory.setCourseList(updatedCategory.getCourseList());
            return categoriesRepository.save(existingCategory);
        } else {
            throw new RuntimeException("Category not found with id: " + updatedCategory.getCategoryId());
        }
    }

    @Override
    public void deleteCategory(Long categoryId) {
        categoriesRepository.deleteById(categoryId);
    }

}
