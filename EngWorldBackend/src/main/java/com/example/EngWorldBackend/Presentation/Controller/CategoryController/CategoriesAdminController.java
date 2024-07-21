package com.example.EngWorldBackend.Presentation.Controller.CategoryController;

import com.example.EngWorldBackend.DTO.Categories.CategoriesDto;
import com.example.EngWorldBackend.DTO.Categories.CategoriesResponse;
import com.example.EngWorldBackend.Domain.Model.Categories;
import com.example.EngWorldBackend.Domain.Respones.ResponseObject;
import com.example.EngWorldBackend.Domain.Respones.ResponseUtils;
import com.example.EngWorldBackend.Domain.Service.CategoryService.CategoryService;
import com.example.EngWorldBackend.Mapper.CategoriesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.EngWorldBackend.Domain.Respones.ResponseMessages.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/categories")
public class CategoriesAdminController {

    private final CategoryService categoriesService;


    // Categories
    @PostMapping("/add")
    public ResponseEntity<ResponseObject> addCategory(@RequestBody CategoriesDto newcate) {
        try {
            categoriesService.createCategory(CategoriesMapper.toEntity(newcate));
            return ResponseUtils.buildCreatedResponse(newcate, CREATED_SUCCESS_RESPONES);
        } catch (Exception e) {
            return ResponseUtils.buildErrorResponse(HttpStatus.BAD_REQUEST, BAD_REQUEST + e.getMessage());
        }
    }

    @GetMapping("/get")
    public ResponseEntity<ResponseObject> getAllCategories(
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize) {
        Page<Categories> categories = categoriesService.getAllCategories(pageNumber, pageSize);
        List<CategoriesDto> response = new ArrayList<>();

        for (Categories category : categories) {
            CategoriesDto categoryDto = CategoriesMapper.toDTO(category);
            response.add(categoryDto);
        }
        CategoriesResponse categoriesResponse = CategoriesMapper.mapToCategoryResponse(response, categories);
        return ResponseUtils.buildSuccessResponse(categoriesResponse, SUCCESS_RESPONSE);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseObject> deleteCategoryById(@RequestParam long categoryId) {
        try {
            categoriesService.deleteCategory(categoryId);
            return ResponseUtils.buildCreatedResponse(null, DELETE_SUCCESS_RESPONSE);
        } catch (Exception e) {
            return ResponseUtils.buildErrorResponse(HttpStatus.BAD_REQUEST, "Failed to delete data: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> findCategoryById(@PathVariable long id) {
        Optional<Categories> optionalCategory = categoriesService.getCategoryById(id);
        if (optionalCategory.isPresent()) {
            Categories category = optionalCategory.get();
            CategoriesDto categoryDto = CategoriesMapper.toDTO(category);
            return ResponseUtils.buildSuccessResponse(categoryDto, SUCCESS_RESPONSE);
        } else {
            return ResponseUtils.buildErrorResponse(HttpStatus.NOT_FOUND, NOTFOUND_RESPONSE + id);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<ResponseObject> updateCategoryById(@RequestParam long id, @RequestBody Categories newCategory) throws Exception {
        try {
            CategoriesDto categoryUpdated = CategoriesMapper.toDTO(categoriesService.updateCategory(id, newCategory));
            return ResponseUtils.buildCreatedResponse(categoryUpdated, SUCCESS_RESPONSE);
        } catch (Exception e) {
            return ResponseUtils.buildErrorResponse(HttpStatus.BAD_REQUEST, BAD_REQUEST + e.getMessage());
        }
    }


}