package com.school.hei.repository;

import com.school.hei.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CourseRepository extends JpaRepository<Course, UUID> {
}
