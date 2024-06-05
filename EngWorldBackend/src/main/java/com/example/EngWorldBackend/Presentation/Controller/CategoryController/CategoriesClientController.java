package com.example.EngWorldBackend.Presentation.Controller.CategoryController;

import com.example.EngWorldBackend.Domain.Respones.ResponseObject;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/client/categories")
public class CategoriesClientController {

    private final CategoriesAdminController categoriesAdminController;

    @GetMapping("/get")
    public ResponseEntity<ResponseObject> getAllCategories() {
        return categoriesAdminController.getAllCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> findCategoryById(@PathVariable long id) {
        return categoriesAdminController.findCategoryById(id);
    }
}
