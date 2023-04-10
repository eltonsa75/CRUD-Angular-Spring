package com.elton.service;


import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;

import com.elton.dto.CourseDTO;
import com.elton.dto.mapper.CourseMapper;
import com.elton.enums.Category;
import com.elton.exception.RecordNotFoundException;

import com.elton.repository.CourseRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@Service
public class CourseService {

    private  final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public CourseService(CourseRepository courseRepository, CourseMapper CourseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = CourseMapper;
    }

    public List<CourseDTO> list() {
       return courseRepository.findAll()
       .stream()
       .map(courseMapper::toDTO)
       .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);   
    }

    public CourseDTO findById(@PathVariable @NotNull @Positive Long id){
        return courseRepository.findById(id)
        .map(courseMapper::toDTO)
        .orElseThrow(() -> new RecordNotFoundException(id));       
    }

    public CourseDTO create(@Valid @NotNull CourseDTO course) {        
        return courseMapper.toDTO(courseRepository.save(courseMapper.toEntity(course)));    
    }

    public CourseDTO update(@NotNull @Positive Long id, @Valid @NotNull CourseDTO course){
        return courseRepository.findById(id)
        .map(recordFound -> {
            recordFound.setName(course.name());
            recordFound.setCategory(Category.FRONT_END);
            return courseMapper.toDTO(courseRepository.save(recordFound));
        })
        .orElseThrow(() -> new RecordNotFoundException(id)); 
     }

     public void delete(@PathVariable @NotNull @Positive Long id) {

        courseRepository.delete(courseRepository
        .findById(id).orElseThrow(() -> new RecordNotFoundException(id)));
  
     }

}