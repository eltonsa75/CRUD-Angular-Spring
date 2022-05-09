package com.elton.controller;

import java.util.List;

import com.elton.model.Course;
import com.elton.repository.CourseRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CourseController {

    private  final CourseRepository courseRepository;


    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public List<Course> list() {
        return courseRepository.findAll();
    }

    //@RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public Course create(@RequestBody Course course) {
        return courseRepository.save(course);
        
    }
   
}
