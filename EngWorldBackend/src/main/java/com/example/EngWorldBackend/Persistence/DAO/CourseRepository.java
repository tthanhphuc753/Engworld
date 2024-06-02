package com.example.EngWorldBackend.Persistence.DAO;

import com.example.EngWorldBackend.Domain.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

    public List<Course> getAllByCategory(Long id);
}
