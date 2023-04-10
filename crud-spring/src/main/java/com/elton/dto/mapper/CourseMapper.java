package com.elton.dto.mapper;

import org.springframework.stereotype.Component;

import com.elton.dto.CourseDTO;
import com.elton.enums.Category;
import com.elton.model.Course;

@Component
public class CourseMapper {

    public CourseDTO toDTO(Course course) {
        if(course == null) {
            return null;
        }
        return new CourseDTO(course.getId(), course.getName(), course.getCategory().getValue());
    }

    public Course toEntity(CourseDTO courseDTO) {
        if(courseDTO == null) {
            return null;
        }
        Course course = new Course();
        if (courseDTO.id() != null) {
            course.setId(courseDTO.id());
        }
        course.setName(courseDTO.name());
        // TODO: use a mapper for Category
        course.setCategory(convertCategoryValue(courseDTO.category()));
            return course;
    }

    public Category convertCategoryValue(String value) {
        if(value == null) {
            return null;
        }
       return switch (value) {
        case "Front-end" -> Category.FRONT_END;
        case "Back-end" -> Category.BACK_END;
        default -> throw new IllegalArgumentException("Categoria inválida: " + value);
    };
}
}
