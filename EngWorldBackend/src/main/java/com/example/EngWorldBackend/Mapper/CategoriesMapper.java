package com.example.EngWorldBackend.Mapper;

import com.example.EngWorldBackend.DTO.CategoriesDto;
import com.example.EngWorldBackend.Domain.Model.Categories;

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
}
