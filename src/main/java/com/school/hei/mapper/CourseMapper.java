package com.school.hei.mapper;

import com.school.hei.model.Course;
import com.school.hei.repository.model.JCourse;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {
    public Course toModel(JCourse entity) {
        return Course.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .startDate(entity.getStart())
                .endDate(entity.getEnd())
                .build();
    }

    public JCourse toEntity(Course model) {
        return JCourse.builder()
                .id(model.getId())
                .title(model.getTitle())
                .start(model.getStartDate())
                .end(model.getEndDate())
                .build();
    }
}
