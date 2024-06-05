package com.example.EngWorldBackend.Domain.Service.CourseService;

import com.example.EngWorldBackend.Domain.Model.Categories;
import com.example.EngWorldBackend.Domain.Model.Course;
import com.example.EngWorldBackend.Persistence.DAO.CategoriesRepository;
import com.example.EngWorldBackend.Persistence.DAO.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CategoriesRepository categoriesRepository;

    @Override
    public Course createCourse(Course newCourse) {
        return courseRepository.save(newCourse);
    }

    @Override
    public Optional<Course> getCourseById(Long courseId) {
        return courseRepository.findById(courseId);
    }


    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public void deleteCourseById(Long courseId) {
        try {
            courseRepository.deleteById(courseId);
        } catch (EmptyResultDataAccessException e) {
            throw new CourseNotFoundException("Course with ID: " + courseId + " does not exist");
        }
    }

    @Override
    public List<Course> getCourseByCate(Long cateId) {
        return courseRepository.getAllByCategory(cateId);
    }

    @Override
    public Course updateCourseById(Long courseId, Course newCourse) throws CourseNotFoundException {
        Optional<Course> courseOptional = courseRepository.findById(courseId);
        if (courseOptional.isPresent()) {
            Course existingCourse = courseOptional.get();
            existingCourse.setCourseName(newCourse.getCourseName());
            existingCourse.setCourseLevel(newCourse.getCourseLevel());
            existingCourse.setCourseDes(newCourse.getCourseDes());
            existingCourse.setCategory(addCategoryToCourse(newCourse.getCategory()));
            return courseRepository.save(existingCourse);
        } else {
            throw new CourseNotFoundException("Course not found with id: " + courseId);
        }
    }

    private Categories addCategoryToCourse(Categories category) {
        return categoriesRepository.findById(category.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException("Category not found with id: " + category.getCategoryId()));
    }

    private static class CourseNotFoundException extends RuntimeException {
        public CourseNotFoundException(String message) {
            super(message);
        }
    }

    private static class CategoryNotFoundException extends RuntimeException {
        public CategoryNotFoundException(String message) {
            super(message);
        }
    }
}