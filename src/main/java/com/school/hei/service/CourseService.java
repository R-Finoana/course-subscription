package com.school.hei.service;

import com.school.hei.mapper.CourseMapper;
import com.school.hei.model.Course;
import com.school.hei.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class CourseService {
    private final CourseMapper mapper;
    private final CourseRepository repository;

    public Course getById(UUID id){
        return mapper.toModel(
                repository.findById(id).orElseThrow(() -> new RuntimeException("Course with id "+id+ " not found"))
        );
    }
}
