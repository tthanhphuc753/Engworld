package com.example.EngWorldBackend.DTO;

import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link com.example.EngWorldBackend.Domain.Model.Categories}
 */
@Data
public class CategoriesDto implements Serializable {
    Long categoryId;
    String categoryname;
}