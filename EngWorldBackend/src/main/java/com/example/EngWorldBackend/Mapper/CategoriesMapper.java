package com.example.EngWorldBackend.Mapper;

import com.example.EngWorldBackend.DTO.Categories.CategoriesDto;
import com.example.EngWorldBackend.DTO.Categories.CategoriesResponse;
import com.example.EngWorldBackend.Domain.Model.Categories;
import org.springframework.data.domain.Page;

import java.util.List;

public class CategoriesMapper {

    public static CategoriesDto toDTO(Categories categories) {
        CategoriesDto dto = new CategoriesDto();
        dto.setCategoryId(categories.getCategoryId());
        dto.setCategoryname(categories.getCategoryname());
        return dto;
    }

    public static Categories toEntity(CategoriesDto dto) {
        Categories categories = new Categories();
        categories.setCategoryId(dto.getCategoryId());
        categories.setCategoryname(dto.getCategoryname());
        return categories;

    }

    public static CategoriesResponse mapToCategoryResponse(List<CategoriesDto> categoryDtos, Page<Categories> categories) {
        CategoriesResponse categoryResponse = new CategoriesResponse();
        categoryResponse.setContent(categoryDtos);
        categoryResponse.setPageNumber(categories.getNumber());
        categoryResponse.setPageSize(categories.getSize());
        categoryResponse.setTotalElements(categories.getTotalElements());
        categoryResponse.setTotalPages(categories.getTotalPages());
        categoryResponse.setLast(categories.isLast());

        return categoryResponse;
    }
}
