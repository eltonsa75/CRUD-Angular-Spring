package com.elton.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elton.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{
    
}
