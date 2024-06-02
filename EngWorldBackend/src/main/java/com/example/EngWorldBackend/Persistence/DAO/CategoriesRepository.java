package com.example.EngWorldBackend.Persistence.DAO;

import com.example.EngWorldBackend.Domain.Model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories,Long> {




}
