package com.example.EngWorldBackend.Presentation.Controller.CategoryController;

import com.example.EngWorldBackend.Domain.Respones.ResponseObject;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/client/categories")
public class CategoriesClientController {

    private final CategoriesAdminController categoriesAdminController;

    @GetMapping("/get")
    public ResponseEntity<ResponseObject> getAllCategories(
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize) {
        return categoriesAdminController.getAllCategories(pageNumber, pageSize);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> findCategoryById(@PathVariable long id) {
        return categoriesAdminController.findCategoryById(id);
    }
}
